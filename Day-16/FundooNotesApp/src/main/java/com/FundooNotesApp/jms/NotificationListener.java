package com.FundooNotesApp.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * JMS consumer — listens on the "note.reminders" queue.
 *
 * Logs the reminder to the console when fired by ReminderScheduler.
 * TODO: inject JavaMailSender here to send real Gmail emails when ready.
 */
@Component
public class NotificationListener {

    private static final Logger log = LoggerFactory.getLogger(NotificationListener.class);

    @JmsListener(destination = "note.reminders", containerFactory = "jmsListenerContainerFactory")
    public void onReminderMessage(NotificationMessage message) {
        log.info("==================================================");
        log.info("[JMS NOTIFICATION] Reminder fired!");
        log.info("  Note ID   : {}", message.getNoteId());
        log.info("  User ID   : {}", message.getUserId());
        log.info("  Title     : {}", message.getTitle());
        log.info("  Scheduled : {}", message.getReminderAt());
        log.info("==================================================");
    }
}
