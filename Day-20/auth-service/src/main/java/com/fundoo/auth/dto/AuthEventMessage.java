package com.fundoo.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthEventMessage implements Serializable {
    private String eventType;
    private String email;
    private LocalDateTime timestamp;
}
