package com.fundoo.auth.controller;

import com.fundoo.auth.dto.*;
import com.fundoo.auth.dto.response.ApiResponse;
import com.fundoo.auth.dto.response.AuthResponse;
import com.fundoo.auth.entity.User;
import com.fundoo.auth.security.JwtUtil;
import com.fundoo.auth.service.RabbitMQPublisher;
import com.fundoo.auth.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<ApiResponse<User>> register(@Valid @RequestBody RegisterRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        User registeredUser = userService.register(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("User registered successfully", registeredUser));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthResponse>> login(@Valid @RequestBody LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        User user = userService.findByEmail(request.getEmail());
        String token = jwtUtil.generateToken(user.getId(), user.getEmail());

        jwtUtil.cacheToken(token, 60 * 60);
        rabbitMQPublisher.sendLoginEvent(user.getEmail());

        return ResponseEntity.ok(ApiResponse.success("Login successful", new AuthResponse(token)));
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<ApiResponse<MessageResponse>> forgotPassword(@Valid @RequestBody ForgotPasswordRequest request) {
        MessageResponse response = userService.forgotPassword(request.getEmail());
        return ResponseEntity.ok(ApiResponse.success("Password reset instructions sent", response));
    }

    @PostMapping("/reset-password")
    public ResponseEntity<ApiResponse<MessageResponse>> resetPassword(@Valid @RequestBody ResetPasswordRequest request) {
        MessageResponse response = userService.resetPassword(request.getToken(), request.getNewPassword());
        return ResponseEntity.ok(ApiResponse.success("Password reset successfully", response));
    }

    @GetMapping("/validate")
    public ResponseEntity<ApiResponse<Boolean>> validateToken(@RequestParam("token") String token) {
        boolean isValid = jwtUtil.validateToken(token);
        return ResponseEntity.ok(ApiResponse.success("Token validation state", isValid));
    }
}
