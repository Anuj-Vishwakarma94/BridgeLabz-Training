package com.fundoo.reminder.jms;

import com.fundoo.reminder.config.JmsConfig;
import com.fundoo.reminder.service.EmailService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {

    private final EmailService emailService;

    public NotificationListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @JmsListener(destination = JmsConfig.REMINDER_QUEUE)
    public void receiveReminderMessage(String message) {
        System.out.println("Received JMS Reminder Event: " + message);
        // Process message format: REMINDER:noteId:userId:reminderAt
        if (message != null && message.startsWith("REMINDER:")) {
            String[] parts = message.split(":");
            if (parts.length >= 4) {
                String noteId = parts[1];
                String userId = parts[2];
                String reminderAt = parts[3];
                System.out.println("Reminder triggered for Note #" + noteId + " owned by User #" + userId + " scheduled at " + reminderAt);
            }
        }
    }
}
