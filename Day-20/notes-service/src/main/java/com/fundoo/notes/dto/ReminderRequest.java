package com.fundoo.notes.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReminderRequest {
    private LocalDateTime reminderAt;
}
