package com.fundoo.notes.service;

import com.fundoo.notes.dto.response.NoteResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface NoteService {
    NoteResponseDTO createNote(Long userId, String title, String content);
    List<NoteResponseDTO> findByOwner(Long userId);
    NoteResponseDTO updateNote(Long noteId, String title, String content, Long userId);
    void deleteNote(Long noteId, Long userId);

    NoteResponseDTO pinNote(Long noteId, Long userId);
    NoteResponseDTO archiveNote(Long noteId, Long userId);
    NoteResponseDTO trashNote(Long noteId, Long userId);

    List<NoteResponseDTO> getPinnedNotes(Long userId);
    List<NoteResponseDTO> getArchivedNotes(Long userId);
    List<NoteResponseDTO> getTrashedNotes(Long userId);

    List<NoteResponseDTO> searchNotes(Long userId, String query);

    NoteResponseDTO addLabelToNote(Long noteId, Long labelId, Long userId);
    NoteResponseDTO removeLabelFromNote(Long noteId, Long labelId, Long userId);

    NoteResponseDTO setReminder(Long noteId, Long userId, LocalDateTime reminderAt);
}
