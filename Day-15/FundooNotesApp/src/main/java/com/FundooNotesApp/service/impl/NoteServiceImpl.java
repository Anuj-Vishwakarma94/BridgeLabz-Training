package com.FundooNotesApp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.FundooNotesApp.dto.response.NoteResponseDTO;
import com.FundooNotesApp.entity.Label;
import com.FundooNotesApp.entity.Note;
import com.FundooNotesApp.entity.User;
import com.FundooNotesApp.mapper.NoteMapper;
import com.FundooNotesApp.repository.LabelRepository;
import com.FundooNotesApp.repository.NoteRepository;
import com.FundooNotesApp.repository.UserRepository;
import com.FundooNotesApp.service.NoteService;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;
    private final LabelRepository labelRepository;
    private final NoteMapper noteMapper;

    public NoteServiceImpl(NoteRepository noteRepository, UserRepository userRepository,
                           LabelRepository labelRepository, NoteMapper noteMapper) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
        this.labelRepository = labelRepository;
        this.noteMapper = noteMapper;
    }

    // -------------------------------------------------------------------------
    // Core CRUD
    // -------------------------------------------------------------------------

    @Override
    public NoteResponseDTO createNote(Long userId, String title, String content) {
        User owner = findUser(userId);
        Note note = new Note();
        note.setTitle(title);
        note.setContent(content);
        note.setOwner(owner);
        return noteMapper.toResponseDTO(noteRepository.save(note));
    }

    @Override
    public List<NoteResponseDTO> findByOwner(Long userId) {
        User owner = findUser(userId);
        return noteRepository.findByOwnerAndTrashedFalse(owner)
                .stream()
                .map(noteMapper::toResponseDTO)
                .toList();
    }

    @Override
    public boolean deleteNote(Long noteId, Long requestingUserId) {
        User owner = findUser(requestingUserId);
        return noteRepository.findByNoteIdAndOwner(noteId, owner)
                .map(note -> {
                    noteRepository.delete(note);
                    return true;
                })
                .orElse(false);
    }

    @Override
    public NoteResponseDTO updateNote(Long noteId, String title, String content, Long requestingUserId) {
        User owner = findUser(requestingUserId);
        Note note = findNoteByOwner(noteId, owner);
        if (title != null)   note.setTitle(title);
        if (content != null) note.setContent(content);
        return noteMapper.toResponseDTO(noteRepository.save(note));
    }

    // -------------------------------------------------------------------------
    // Pin / Archive / Trash toggles
    // -------------------------------------------------------------------------

    @Override
    public NoteResponseDTO pinNote(Long noteId, Long userId) {
        User owner = findUser(userId);
        Note note = findNoteByOwner(noteId, owner);
        note.setPinned(!note.isPinned());
        return noteMapper.toResponseDTO(noteRepository.save(note));
    }

    @Override
    public NoteResponseDTO archiveNote(Long noteId, Long userId) {
        User owner = findUser(userId);
        Note note = findNoteByOwner(noteId, owner);
        note.setArchived(!note.isArchived());
        return noteMapper.toResponseDTO(noteRepository.save(note));
    }

    @Override
    public NoteResponseDTO trashNote(Long noteId, Long userId) {
        User owner = findUser(userId);
        Note note = findNoteByOwner(noteId, owner);
        boolean nowTrashed = !note.isTrashed();
        note.setTrashed(nowTrashed);
        // When trashing, clear pin & archive for a clean state
        if (nowTrashed) {
            note.setPinned(false);
            note.setArchived(false);
        }
        return noteMapper.toResponseDTO(noteRepository.save(note));
    }

    // -------------------------------------------------------------------------
    // State-based filters
    // -------------------------------------------------------------------------

    @Override
    public List<NoteResponseDTO> getPinnedNotes(Long userId) {
        User owner = findUser(userId);
        return noteRepository.findByOwnerAndPinnedTrueAndTrashedFalse(owner)
                .stream().map(noteMapper::toResponseDTO).toList();
    }

    @Override
    public List<NoteResponseDTO> getArchivedNotes(Long userId) {
        User owner = findUser(userId);
        return noteRepository.findByOwnerAndArchivedTrueAndTrashedFalse(owner)
                .stream().map(noteMapper::toResponseDTO).toList();
    }

    @Override
    public List<NoteResponseDTO> getTrashedNotes(Long userId) {
        User owner = findUser(userId);
        return noteRepository.findByOwnerAndTrashedTrue(owner)
                .stream().map(noteMapper::toResponseDTO).toList();
    }

    // -------------------------------------------------------------------------
    // Search
    // -------------------------------------------------------------------------

    @Override
    public List<NoteResponseDTO> searchNotes(Long userId, String query) {
        User owner = findUser(userId);
        return noteRepository.searchByOwnerAndKeyword(owner, query)
                .stream().map(noteMapper::toResponseDTO).toList();
    }

    // -------------------------------------------------------------------------
    // Label assignment
    // -------------------------------------------------------------------------

    @Override
    public NoteResponseDTO addLabelToNote(Long noteId, Long labelId, Long userId) {
        User owner = findUser(userId);
        Note note = findNoteByOwner(noteId, owner);
        Label label = labelRepository.findByLabelIdAndOwner(labelId, owner)
                .orElseThrow(() -> new IllegalArgumentException("Label not found or unauthorized"));

        if (!note.getLabels().contains(label)) {
            note.getLabels().add(label);
        }
        return noteMapper.toResponseDTO(noteRepository.save(note));
    }

    @Override
    public NoteResponseDTO removeLabelFromNote(Long noteId, Long labelId, Long userId) {
        User owner = findUser(userId);
        Note note = findNoteByOwner(noteId, owner);
        Label label = labelRepository.findByLabelIdAndOwner(labelId, owner)
                .orElseThrow(() -> new IllegalArgumentException("Label not found or unauthorized"));

        note.getLabels().remove(label);
        return noteMapper.toResponseDTO(noteRepository.save(note));
    }

    // -------------------------------------------------------------------------
    // Private helpers
    // -------------------------------------------------------------------------

    private User findUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    private Note findNoteByOwner(Long noteId, User owner) {
        return noteRepository.findByNoteIdAndOwner(noteId, owner)
                .orElseThrow(() -> new IllegalArgumentException("Note not found or unauthorized"));
    }
}

