package com.fundoo.notes.service;

import com.fundoo.notes.config.JmsConfig;
import com.fundoo.notes.dto.response.NoteResponseDTO;
import com.fundoo.notes.entity.Label;
import com.fundoo.notes.entity.Note;
import com.fundoo.notes.exception.ResourceNotFoundException;
import com.fundoo.notes.mapper.NoteMapper;
import com.fundoo.notes.repository.LabelRepository;
import com.fundoo.notes.repository.NoteRepository;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;
    private final LabelRepository labelRepository;
    private final NoteMapper noteMapper;
    private final JmsTemplate jmsTemplate;

    public NoteServiceImpl(
            NoteRepository noteRepository,
            LabelRepository labelRepository,
            NoteMapper noteMapper,
            JmsTemplate jmsTemplate) {
        this.noteRepository = noteRepository;
        this.labelRepository = labelRepository;
        this.noteMapper = noteMapper;
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public NoteResponseDTO createNote(Long userId, String title, String content) {
        Note note = new Note();
        note.setUserId(userId);
        note.setTitle(title);
        note.setContent(content);
        return noteMapper.toDTO(noteRepository.save(note));
    }

    @Override
    public List<NoteResponseDTO> findByOwner(Long userId) {
        return noteMapper.toDTOList(noteRepository.findByUserId(userId));
    }

    @Override
    public NoteResponseDTO updateNote(Long noteId, String title, String content, Long userId) {
        Note note = findNote(noteId, userId);
        note.setTitle(title);
        note.setContent(content);
        return noteMapper.toDTO(noteRepository.save(note));
    }

    @Override
    public void deleteNote(Long noteId, Long userId) {
        Note note = findNote(noteId, userId);
        noteRepository.delete(note);
    }

    @Override
    public NoteResponseDTO pinNote(Long noteId, Long userId) {
        Note note = findNote(noteId, userId);
        note.setPinned(!note.isPinned());
        return noteMapper.toDTO(noteRepository.save(note));
    }

    @Override
    public NoteResponseDTO archiveNote(Long noteId, Long userId) {
        Note note = findNote(noteId, userId);
        note.setArchived(!note.isArchived());
        return noteMapper.toDTO(noteRepository.save(note));
    }

    @Override
    public NoteResponseDTO trashNote(Long noteId, Long userId) {
        Note note = findNote(noteId, userId);
        note.setTrashed(!note.isTrashed());
        return noteMapper.toDTO(noteRepository.save(note));
    }

    @Override
    public List<NoteResponseDTO> getPinnedNotes(Long userId) {
        return noteMapper.toDTOList(noteRepository.findByUserIdAndPinnedTrue(userId));
    }

    @Override
    public List<NoteResponseDTO> getArchivedNotes(Long userId) {
        return noteMapper.toDTOList(noteRepository.findByUserIdAndArchivedTrue(userId));
    }

    @Override
    public List<NoteResponseDTO> getTrashedNotes(Long userId) {
        return noteMapper.toDTOList(noteRepository.findByUserIdAndTrashedTrue(userId));
    }

    @Override
    public List<NoteResponseDTO> searchNotes(Long userId, String query) {
        return noteMapper.toDTOList(noteRepository.searchNotes(userId, query));
    }

    @Override
    public NoteResponseDTO addLabelToNote(Long noteId, Long labelId, Long userId) {
        Note note = findNote(noteId, userId);
        Label label = labelRepository.findByLabelIdAndUserId(labelId, userId)
                .orElseThrow(() -> new ResourceNotFoundException("Label not found with ID: " + labelId));
        if (!note.getLabels().contains(label)) {
            note.getLabels().add(label);
        }
        return noteMapper.toDTO(noteRepository.save(note));
    }

    @Override
    public NoteResponseDTO removeLabelFromNote(Long noteId, Long labelId, Long userId) {
        Note note = findNote(noteId, userId);
        Label label = labelRepository.findByLabelIdAndUserId(labelId, userId)
                .orElseThrow(() -> new ResourceNotFoundException("Label not found with ID: " + labelId));
        note.getLabels().remove(label);
        return noteMapper.toDTO(noteRepository.save(note));
    }

    @Override
    public NoteResponseDTO setReminder(Long noteId, Long userId, LocalDateTime reminderAt) {
        Note note = findNote(noteId, userId);
        note.setReminderAt(reminderAt);
        note.setReminderSent(false);
        Note saved = noteRepository.save(note);

        // Publish reminder event to JMS queue
        try {
            String message = "REMINDER:" + noteId + ":" + userId + ":" + reminderAt;
            jmsTemplate.convertAndSend(JmsConfig.REMINDER_QUEUE, message);
        } catch (Exception e) {
            System.err.println("Failed to publish JMS reminder: " + e.getMessage());
        }

        return noteMapper.toDTO(saved);
    }

    private Note findNote(Long noteId, Long userId) {
        return noteRepository.findByNoteIdAndUserId(noteId, userId)
                .orElseThrow(() -> new ResourceNotFoundException("Note not found with ID: " + noteId));
    }
}
