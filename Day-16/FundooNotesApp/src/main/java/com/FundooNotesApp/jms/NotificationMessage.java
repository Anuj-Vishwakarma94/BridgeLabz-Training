package com.FundooNotesApp.jms;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

/**
 * JMS message payload sent to the "note.reminders" queue.
 *
 * Sent as a JSON TextMessage (via MappingJackson2MessageConverter + JavaTimeModule),
 * so ActiveMQ's deserialization trust filter is never involved.
 *
 * Jackson requirements: no-arg constructor + getters for all fields.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NotificationMessage {

    private Long noteId;
    private Long userId;
    private String title;
    private LocalDateTime reminderAt;

    // Required by Jackson for deserialization
    public NotificationMessage() {}

    public NotificationMessage(Long noteId, Long userId, String title, LocalDateTime reminderAt) {
        this.noteId     = noteId;
        this.userId     = userId;
        this.title      = title;
        this.reminderAt = reminderAt;
    }

    // --- Getters (required by Jackson) ---
    public Long getNoteId()              { return noteId; }
    public Long getUserId()              { return userId; }
    public String getTitle()             { return title; }
    public LocalDateTime getReminderAt() { return reminderAt; }

    @Override
    public String toString() {
        return "NotificationMessage{noteId=" + noteId +
               ", userId=" + userId +
               ", title='" + title + '\'' +
               ", reminderAt=" + reminderAt + '}';
    }
}
