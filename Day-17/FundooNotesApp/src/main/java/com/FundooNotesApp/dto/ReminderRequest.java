package com.FundooNotesApp.dto;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * Request body for setting (or updating) a reminder on a Note.
 * The client sends an ISO-8601 datetime string which Jackson deserialises
 * automatically into a LocalDateTime.
 */
@Data
public class ReminderRequest {

    /** When the reminder should fire, e.g. "2026-08-24T10:30:00" */
    private LocalDateTime reminderAt;
}
