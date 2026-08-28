package com.fundoo.gateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @GetMapping("/auth")
    public Mono<ResponseEntity<Map<String, Object>>> authFallback() {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now().toString());
        response.put("status", HttpStatus.SERVICE_UNAVAILABLE.value());
        response.put("error", "Service Unavailable");
        response.put("message", "Auth Service is currently taking too long to respond or is down. Please try again later.");
        response.put("path", "/api/auth");
        return Mono.just(ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response));
    }

    @GetMapping("/notes")
    public Mono<ResponseEntity<Map<String, Object>>> notesFallback() {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now().toString());
        response.put("status", HttpStatus.SERVICE_UNAVAILABLE.value());
        response.put("error", "Service Unavailable");
        response.put("message", "Notes Service is currently taking too long to respond or is down. Please try again later.");
        response.put("path", "/api/notes");
        return Mono.just(ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response));
    }

    @GetMapping("/reminders")
    public Mono<ResponseEntity<Map<String, Object>>> remindersFallback() {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now().toString());
        response.put("status", HttpStatus.SERVICE_UNAVAILABLE.value());
        response.put("error", "Service Unavailable");
        response.put("message", "Reminder Service is currently taking too long to respond or is down. Please try again later.");
        response.put("path", "/api/reminders");
        return Mono.just(ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response));
    }

    @GetMapping("/admin")
    public Mono<ResponseEntity<Map<String, Object>>> adminFallback() {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now().toString());
        response.put("status", HttpStatus.SERVICE_UNAVAILABLE.value());
        response.put("error", "Service Unavailable");
        response.put("message", "Admin Server is currently taking too long to respond or is down. Please try again later.");
        response.put("path", "/admin");
        return Mono.just(ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response));
    }
}
