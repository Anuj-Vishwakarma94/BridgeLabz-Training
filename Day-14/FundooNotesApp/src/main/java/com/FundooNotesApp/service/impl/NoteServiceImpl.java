package com.FundooNotesApp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.FundooNotesApp.dto.response.NoteResponseDTO;
import com.FundooNotesApp.entity.Note;
import com.FundooNotesApp.entity.User;
import com.FundooNotesApp.mapper.NoteMapper;
import com.FundooNotesApp.repository.NoteRepository;
import com.FundooNotesApp.repository.UserRepository;
import com.FundooNotesApp.service.NoteService;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;
    private final NoteMapper noteMapper;

    public NoteServiceImpl(NoteRepository noteRepository, UserRepository userRepository, NoteMapper noteMapper) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
        this.noteMapper = noteMapper;
    }

    @Override
    public NoteResponseDTO createNote(Long userId, String title, String content) {
        User owner = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Note note = new Note();
        note.setTitle(title);
        note.setContent(content);
        note.setOwner(owner);

        Note savedNote = noteRepository.save(note);
        return noteMapper.toResponseDTO(savedNote);
    }

    @Override
    public List<NoteResponseDTO> findByOwner(Long userId) {
        User owner = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        return noteRepository.findByOwner(owner)
                .stream()
                .map(noteMapper::toResponseDTO)
                .toList();
    }

    @Override
    public boolean deleteNote(Long noteId, Long requestingUserId) {
        User owner = userRepository.findById(requestingUserId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        return noteRepository
                .findByNoteIdAndOwner(noteId, owner)
                .map(note -> {
                    noteRepository.delete(note);
                    return true;
                })
                .orElse(false);
    }

    @Override
    public NoteResponseDTO updateNote(Long noteId, String title, String content, Long requestingUserId) {
        User owner = userRepository.findById(requestingUserId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Note note = noteRepository.findByNoteIdAndOwner(noteId, owner)
                .orElseThrow(() -> new IllegalArgumentException("Note not found or unauthorized"));

        if (title != null) {
            note.setTitle(title);
        }
        if (content != null) {
            note.setContent(content);
        }

        Note updatedNote = noteRepository.save(note);
        return noteMapper.toResponseDTO(updatedNote);
    }
}
