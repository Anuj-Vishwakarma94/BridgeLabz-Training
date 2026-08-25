package com.FundooNotesApp.controller;

import com.FundooNotesApp.dto.response.AuthResponse;
import com.FundooNotesApp.dto.ForgotPasswordRequest;
import com.FundooNotesApp.dto.LoginRequest;
import com.FundooNotesApp.dto.MessageResponse;
import com.FundooNotesApp.dto.RegisterRequest;
import com.FundooNotesApp.dto.ResetPasswordRequest;
import com.FundooNotesApp.entity.User;
import com.FundooNotesApp.security.JwtUtil;
import com.FundooNotesApp.service.UserService;

import com.FundooNotesApp.service.RabbitMQPublisher;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/api/auth", "/auth"})
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final RabbitMQPublisher rabbitMQPublisher;

    public AuthController(
            UserService userService,
            JwtUtil jwtUtil,
            AuthenticationManager authenticationManager,
            RabbitMQPublisher rabbitMQPublisher) {

        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
        this.rabbitMQPublisher = rabbitMQPublisher;
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request) {

        User user = new User();

        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        return userService.register(user);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = userService.findByEmail(request.getEmail());
        String token = jwtUtil.generateToken(user.getId(), user.getEmail());

        // Cache the token in Redis (TTL = 1 hour, matching the JWT expiry)
        jwtUtil.cacheToken(token, 60 * 60);

        // Publish RabbitMQ login event
        rabbitMQPublisher.sendLoginEvent(user.getEmail());

        return new AuthResponse(token);
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<MessageResponse> forgotPassword(@RequestBody ForgotPasswordRequest request) {
        MessageResponse response = userService.forgotPassword(request.getEmail());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/reset-password")
    public ResponseEntity<MessageResponse> resetPassword(@RequestBody ResetPasswordRequest request) {
        MessageResponse response = userService.resetPassword(request.getToken(), request.getNewPassword());
        return ResponseEntity.ok(response);
    }
}