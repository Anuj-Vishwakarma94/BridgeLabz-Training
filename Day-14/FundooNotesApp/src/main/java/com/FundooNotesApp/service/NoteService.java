package com.FundooNotesApp.service;

import java.util.List;

import com.FundooNotesApp.dto.response.NoteResponseDTO;

public interface NoteService {

    NoteResponseDTO createNote(Long userId, String title, String content);

    List<NoteResponseDTO> findByOwner(Long userId);

    boolean deleteNote(Long noteId, Long requestingUserId);

    NoteResponseDTO updateNote(Long noteId, String title, String content, Long requestingUserId);
}
