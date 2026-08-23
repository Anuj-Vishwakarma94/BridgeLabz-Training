package com.FundooNotesApp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FundooNotesApp.dto.response.NoteResponseDTO;
import com.FundooNotesApp.entity.Note;
import com.FundooNotesApp.security.CustomUserDetails;
import com.FundooNotesApp.service.NoteService;

@RestController
@RequestMapping({"/notes", "/api/notes"})
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    private Long currentUserId() {
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        return userDetails.getUserId();
    }

    // -------------------------------------------------------------------------
    // Core CRUD
    // -------------------------------------------------------------------------

    @PostMapping
    public ResponseEntity<NoteResponseDTO> createNote(@RequestBody Note note) {
        NoteResponseDTO savedNote = noteService.createNote(currentUserId(), note.getTitle(), note.getContent());
        return ResponseEntity.status(HttpStatus.CREATED).body(savedNote);
    }

    @GetMapping
    public List<NoteResponseDTO> getMyNotes() {
        return noteService.findByOwner(currentUserId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<NoteResponseDTO> updateNote(@PathVariable Long id, @RequestBody Note note) {
        try {
            NoteResponseDTO updatedNote = noteService.updateNote(id, note.getTitle(), note.getContent(), currentUserId());
            return ResponseEntity.ok(updatedNote);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        boolean deleted = noteService.deleteNote(id, currentUserId());
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    // -------------------------------------------------------------------------
    // Pin / Archive / Trash toggles
    // -------------------------------------------------------------------------

    @PatchMapping("/{id}/pin")
    public ResponseEntity<NoteResponseDTO> pinNote(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(noteService.pinNote(id, currentUserId()));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}/archive")
    public ResponseEntity<NoteResponseDTO> archiveNote(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(noteService.archiveNote(id, currentUserId()));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}/trash")
    public ResponseEntity<NoteResponseDTO> trashNote(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(noteService.trashNote(id, currentUserId()));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // -------------------------------------------------------------------------
    // State-based filter endpoints
    // -------------------------------------------------------------------------

    @GetMapping("/pinned")
    public List<NoteResponseDTO> getPinnedNotes() {
        return noteService.getPinnedNotes(currentUserId());
    }

    @GetMapping("/archived")
    public List<NoteResponseDTO> getArchivedNotes() {
        return noteService.getArchivedNotes(currentUserId());
    }

    @GetMapping("/trashed")
    public List<NoteResponseDTO> getTrashedNotes() {
        return noteService.getTrashedNotes(currentUserId());
    }

    // -------------------------------------------------------------------------
    // Search
    // -------------------------------------------------------------------------

    @GetMapping("/search")
    public List<NoteResponseDTO> searchNotes(@RequestParam String q) {
        return noteService.searchNotes(currentUserId(), q);
    }

    // -------------------------------------------------------------------------
    // Label assignment
    // -------------------------------------------------------------------------

    @PostMapping("/{noteId}/labels/{labelId}")
    public ResponseEntity<NoteResponseDTO> addLabel(@PathVariable Long noteId, @PathVariable Long labelId) {
        try {
            return ResponseEntity.ok(noteService.addLabelToNote(noteId, labelId, currentUserId()));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{noteId}/labels/{labelId}")
    public ResponseEntity<NoteResponseDTO> removeLabel(@PathVariable Long noteId, @PathVariable Long labelId) {
        try {
            return ResponseEntity.ok(noteService.removeLabelFromNote(noteId, labelId, currentUserId()));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

