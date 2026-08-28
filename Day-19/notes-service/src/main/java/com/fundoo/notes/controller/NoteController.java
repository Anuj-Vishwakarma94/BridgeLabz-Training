package com.fundoo.notes.controller;

import com.fundoo.notes.dto.ReminderRequest;
import com.fundoo.notes.dto.response.ApiResponse;
import com.fundoo.notes.dto.response.NoteResponseDTO;
import com.fundoo.notes.entity.Note;
import com.fundoo.notes.security.CustomUserDetails;
import com.fundoo.notes.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping
    public ResponseEntity<ApiResponse<NoteResponseDTO>> createNote(@RequestBody Note note) {
        NoteResponseDTO savedNote = noteService.createNote(currentUserId(), note.getTitle(), note.getContent());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Note created successfully", savedNote));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<NoteResponseDTO>>> getMyNotes() {
        List<NoteResponseDTO> notes = noteService.findByOwner(currentUserId());
        return ResponseEntity.ok(ApiResponse.success("Fetched user notes successfully", notes));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<NoteResponseDTO>> updateNote(@PathVariable Long id, @RequestBody Note note) {
        NoteResponseDTO updatedNote = noteService.updateNote(id, note.getTitle(), note.getContent(), currentUserId());
        return ResponseEntity.ok(ApiResponse.success("Note updated successfully", updatedNote));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id, currentUserId());
        return ResponseEntity.ok(ApiResponse.success("Note deleted successfully", null));
    }

    @PatchMapping("/{id}/pin")
    public ResponseEntity<ApiResponse<NoteResponseDTO>> pinNote(@PathVariable Long id) {
        NoteResponseDTO note = noteService.pinNote(id, currentUserId());
        return ResponseEntity.ok(ApiResponse.success("Note pin status updated", note));
    }

    @PatchMapping("/{id}/archive")
    public ResponseEntity<ApiResponse<NoteResponseDTO>> archiveNote(@PathVariable Long id) {
        NoteResponseDTO note = noteService.archiveNote(id, currentUserId());
        return ResponseEntity.ok(ApiResponse.success("Note archive status updated", note));
    }

    @PatchMapping("/{id}/trash")
    public ResponseEntity<ApiResponse<NoteResponseDTO>> trashNote(@PathVariable Long id) {
        NoteResponseDTO note = noteService.trashNote(id, currentUserId());
        return ResponseEntity.ok(ApiResponse.success("Note trash status updated", note));
    }

    @GetMapping("/pinned")
    public ResponseEntity<ApiResponse<List<NoteResponseDTO>>> getPinnedNotes() {
        List<NoteResponseDTO> notes = noteService.getPinnedNotes(currentUserId());
        return ResponseEntity.ok(ApiResponse.success("Fetched pinned notes", notes));
    }

    @GetMapping("/archived")
    public ResponseEntity<ApiResponse<List<NoteResponseDTO>>> getArchivedNotes() {
        List<NoteResponseDTO> notes = noteService.getArchivedNotes(currentUserId());
        return ResponseEntity.ok(ApiResponse.success("Fetched archived notes", notes));
    }

    @GetMapping("/trashed")
    public ResponseEntity<ApiResponse<List<NoteResponseDTO>>> getTrashedNotes() {
        List<NoteResponseDTO> notes = noteService.getTrashedNotes(currentUserId());
        return ResponseEntity.ok(ApiResponse.success("Fetched trashed notes", notes));
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<NoteResponseDTO>>> searchNotes(@RequestParam String q) {
        List<NoteResponseDTO> notes = noteService.searchNotes(currentUserId(), q);
        return ResponseEntity.ok(ApiResponse.success("Search results for query: " + q, notes));
    }

    @PostMapping("/{noteId}/labels/{labelId}")
    public ResponseEntity<ApiResponse<NoteResponseDTO>> addLabel(@PathVariable Long noteId, @PathVariable Long labelId) {
        NoteResponseDTO note = noteService.addLabelToNote(noteId, labelId, currentUserId());
        return ResponseEntity.ok(ApiResponse.success("Label added to note", note));
    }

    @DeleteMapping("/{noteId}/labels/{labelId}")
    public ResponseEntity<ApiResponse<NoteResponseDTO>> removeLabel(@PathVariable Long noteId, @PathVariable Long labelId) {
        NoteResponseDTO note = noteService.removeLabelFromNote(noteId, labelId, currentUserId());
        return ResponseEntity.ok(ApiResponse.success("Label removed from note", note));
    }

    @PutMapping("/{id}/reminder")
    public ResponseEntity<ApiResponse<NoteResponseDTO>> setReminder(@PathVariable Long id, @RequestBody ReminderRequest request) {
        NoteResponseDTO updated = noteService.setReminder(id, currentUserId(), request.getReminderAt());
        return ResponseEntity.ok(ApiResponse.success("Reminder set successfully", updated));
    }
}
