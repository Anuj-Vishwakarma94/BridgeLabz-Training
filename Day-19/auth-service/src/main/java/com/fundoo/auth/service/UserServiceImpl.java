package com.fundoo.auth.service;

import com.fundoo.auth.dto.MessageResponse;
import com.fundoo.auth.entity.User;
import com.fundoo.auth.exception.InvalidTokenException;
import com.fundoo.auth.exception.ResourceNotFoundException;
import com.fundoo.auth.exception.UserAlreadyExistsException;
import com.fundoo.auth.repository.UserRepository;
import com.fundoo.auth.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final EmailService emailService;

    public UserServiceImpl(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtUtil jwtUtil,
            EmailService emailService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.emailService = emailService;
    }

    @Override
    public User register(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new UserAlreadyExistsException("User with email " + user.getEmail() + " already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + email));
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));
    }

    @Override
    public MessageResponse forgotPassword(String email) {
        User user = findByEmail(email);
        String resetToken = jwtUtil.generateResetToken(user.getEmail());
        emailService.sendEmail(user.getEmail(), "Password Reset Request",
                "Your password reset token is: " + resetToken);
        return new MessageResponse("Password reset instructions sent to email: " + email);
    }

    @Override
    public MessageResponse resetPassword(String token, String newPassword) {
        if (!jwtUtil.validateToken(token)) {
            throw new InvalidTokenException("Invalid or expired reset token");
        }
        String email = jwtUtil.extractEmail(token);
        User user = findByEmail(email);
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
        jwtUtil.evictToken(token);
        return new MessageResponse("Password updated successfully for: " + email);
    }
}
