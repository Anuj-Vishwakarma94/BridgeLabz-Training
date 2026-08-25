package com.FundooNotesApp.mapper;

import org.springframework.stereotype.Component;

import com.FundooNotesApp.dto.response.NoteResponseDTO;
import com.FundooNotesApp.entity.Note;

@Component
public class NoteMapper {

    public NoteResponseDTO toResponseDTO(Note note) {
        return new NoteResponseDTO(
                note.getNoteId(),
                note.getTitle(),
                note.getContent(),
                note.getCreatedAt(),
                note.isPinned(),
                note.isArchived(),
                note.isTrashed(),
                note.getLabels()
        );
    }
}

