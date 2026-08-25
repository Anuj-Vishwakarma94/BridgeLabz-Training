package com.FundooNotesApp.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AuthEventMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    private String eventType; // e.g. "REGISTER", "LOGIN", "FORGOT_PASSWORD"
    private String email;
    private String details;
    private LocalDateTime timestamp;

    public AuthEventMessage() {
        this.timestamp = LocalDateTime.now();
    }

    public AuthEventMessage(String eventType, String email, String details) {
        this.eventType = eventType;
        this.email = email;
        this.details = details;
        this.timestamp = LocalDateTime.now();
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
