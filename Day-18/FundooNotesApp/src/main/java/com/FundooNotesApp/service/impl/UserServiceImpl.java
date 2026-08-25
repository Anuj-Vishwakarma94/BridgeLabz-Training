package com.FundooNotesApp.service.impl;

import com.FundooNotesApp.dto.MessageResponse;
import com.FundooNotesApp.entity.User;
import com.FundooNotesApp.exception.InvalidTokenException;
import com.FundooNotesApp.exception.ResourceNotFoundException;
import com.FundooNotesApp.exception.UserAlreadyExistsException;
import com.FundooNotesApp.repository.UserRepository;
import com.FundooNotesApp.security.JwtUtil;
import com.FundooNotesApp.service.UserService;
import com.FundooNotesApp.service.RabbitMQPublisher;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final RabbitMQPublisher rabbitMQPublisher;

    public UserServiceImpl(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtUtil jwtUtil,
            RabbitMQPublisher rabbitMQPublisher) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.rabbitMQPublisher = rabbitMQPublisher;
    }

    @Override
    public User register(User user) {
        if (userRepository.findFirstByEmail(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("Email already registered: " + user.getEmail());
        }

        user.setPassword(
                passwordEncoder.encode(user.getPassword())
        );

        User savedUser = userRepository.save(user);

        // Publish RabbitMQ registration event
        rabbitMQPublisher.sendRegisterEvent(savedUser.getEmail());

        return savedUser;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findFirstByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with email: " + email));
    }

    @Override
    public MessageResponse forgotPassword(String email) {
        User user = userRepository.findFirstByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + email));

        String resetToken = jwtUtil.generateResetToken(user.getEmail());

        // Cache the reset token in Redis with a 15-minute TTL (matches JWT expiry)
        jwtUtil.cacheToken(resetToken, 60 * 15);

        // Publish RabbitMQ forgot password event
        rabbitMQPublisher.sendForgotPasswordEvent(user.getEmail(), resetToken);

        return new MessageResponse("Password reset token generated successfully", resetToken);
    }

    @Override
    public MessageResponse resetPassword(String token, String newPassword) {
        if (!jwtUtil.validateToken(token)) {
            throw new InvalidTokenException("Invalid or expired password reset token");
        }

        String email = jwtUtil.extractEmail(token);
        User user = userRepository.findFirstByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + email));

        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);

        // Evict the reset token from Redis so it cannot be replayed
        jwtUtil.evictToken(token);

        return new MessageResponse("Password has been reset successfully");
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        User user = userRepository.findFirstByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .authorities("USER")
                .build();
    }
}
