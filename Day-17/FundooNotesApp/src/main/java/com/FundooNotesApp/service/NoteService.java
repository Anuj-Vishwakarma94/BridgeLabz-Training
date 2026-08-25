package com.FundooNotesApp.service;

import java.time.LocalDateTime;
import java.util.List;

import com.FundooNotesApp.dto.response.NoteResponseDTO;

public interface NoteService {

    NoteResponseDTO createNote(Long userId, String title, String content);

    List<NoteResponseDTO> findByOwner(Long userId);

    boolean deleteNote(Long noteId, Long requestingUserId);

    NoteResponseDTO updateNote(Long noteId, String title, String content, Long requestingUserId);

    // --- Pin / Archive / Trash toggles ---
    NoteResponseDTO pinNote(Long noteId, Long userId);

    NoteResponseDTO archiveNote(Long noteId, Long userId);

    NoteResponseDTO trashNote(Long noteId, Long userId);

    // --- State-based filters ---
    List<NoteResponseDTO> getPinnedNotes(Long userId);

    List<NoteResponseDTO> getArchivedNotes(Long userId);

    List<NoteResponseDTO> getTrashedNotes(Long userId);

    // --- Search ---
    List<NoteResponseDTO> searchNotes(Long userId, String query);

    // --- Label assignment ---
    NoteResponseDTO addLabelToNote(Long noteId, Long labelId, Long userId);

    NoteResponseDTO removeLabelFromNote(Long noteId, Long labelId, Long userId);

    // --- Reminder (JMS) ---
    NoteResponseDTO setReminder(Long noteId, Long userId, LocalDateTime reminderAt);
}


