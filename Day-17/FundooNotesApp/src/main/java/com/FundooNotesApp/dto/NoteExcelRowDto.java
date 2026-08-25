package com.FundooNotesApp.dto;

import java.time.LocalDateTime;

public class NoteExcelRowDto {

    private Long noteId;
    private String title;
    private String content;
    private String ownerEmail;
    private boolean pinned;
    private boolean archived;
    private boolean trashed;
    private LocalDateTime createdAt;

    public NoteExcelRowDto() {
    }

    public NoteExcelRowDto(Long noteId, String title, String content, String ownerEmail,
                           boolean pinned, boolean archived, boolean trashed, LocalDateTime createdAt) {
        this.noteId = noteId;
        this.title = title;
        this.content = content;
        this.ownerEmail = ownerEmail;
        this.pinned = pinned;
        this.archived = archived;
        this.trashed = trashed;
        this.createdAt = createdAt;
    }

    public Long getNoteId() {
        return noteId;
    }

    public void setNoteId(Long noteId) {
        this.noteId = noteId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public boolean isPinned() {
        return pinned;
    }

    public void setPinned(boolean pinned) {
        this.pinned = pinned;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public boolean isTrashed() {
        return trashed;
    }

    public void setTrashed(boolean trashed) {
        this.trashed = trashed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
