package com.FundooNotesApp.jms;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.FundooNotesApp.entity.Note;
import com.FundooNotesApp.repository.NoteRepository;

/**
 * Background scheduler that runs every 60 seconds.
 *
 * For every Note whose reminderAt timestamp has passed and whose
 * notification has not yet been dispatched, it:
 *  1. Publishes a {@link NotificationMessage} to the "note.reminders" JMS queue.
 *  2. Marks reminderSent = true so the same note is not published again.
 */
@Component
public class ReminderScheduler {

    private static final Logger log = LoggerFactory.getLogger(ReminderScheduler.class);

    private final NoteRepository noteRepository;
    private final JmsTemplate    jmsTemplate;

    public ReminderScheduler(NoteRepository noteRepository, JmsTemplate jmsTemplate) {
        this.noteRepository = noteRepository;
        this.jmsTemplate    = jmsTemplate;
    }

    /**
     * Runs every 60 seconds (fixedDelay = 60_000 ms).
     * initialDelay = 10_000 gives the app time to finish startup before the first check.
     */
    @Scheduled(fixedDelay = 60_000, initialDelay = 10_000)
    public void dispatchDueReminders() {
        LocalDateTime now = LocalDateTime.now();
        List<Note> dueNotes = noteRepository.findDueReminders(now);

        if (dueNotes.isEmpty()) {
            log.debug("[ReminderScheduler] No due reminders at {}", now);
            return;
        }

        log.info("[ReminderScheduler] Found {} due reminder(s) at {}", dueNotes.size(), now);

        for (Note note : dueNotes) {
            try {
                NotificationMessage msg = new NotificationMessage(
                        note.getNoteId(),
                        note.getOwner().getId(),
                        note.getTitle(),
                        note.getReminderAt()
                );

                jmsTemplate.convertAndSend("note.reminders", msg);
                log.info("[ReminderScheduler] Published reminder for note '{}' (id={})",
                         note.getTitle(), note.getNoteId());

                // Mark as sent so we don't publish it again next tick
                note.setReminderSent(true);
                noteRepository.save(note);

            } catch (Exception ex) {
                log.error("[ReminderScheduler] Failed to publish reminder for note id={}: {}",
                          note.getNoteId(), ex.getMessage());
            }
        }
    }
}
