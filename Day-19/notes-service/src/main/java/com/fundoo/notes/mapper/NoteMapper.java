package com.fundoo.notes.mapper;

import com.fundoo.notes.dto.response.NoteResponseDTO;
import com.fundoo.notes.entity.Note;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NoteMapper {

    private final LabelMapper labelMapper;

    public NoteMapper(LabelMapper labelMapper) {
        this.labelMapper = labelMapper;
    }

    public NoteResponseDTO toDTO(Note note) {
        if (note == null) return null;
        return new NoteResponseDTO(
                note.getNoteId(),
                note.getTitle(),
                note.getContent(),
                note.getCreatedAt(),
                note.isPinned(),
                note.isArchived(),
                note.isTrashed(),
                note.getReminderAt(),
                note.isReminderSent(),
                labelMapper.toDTOList(note.getLabels())
        );
    }

    public List<NoteResponseDTO> toDTOList(List<Note> notes) {
        if (notes == null) return List.of();
        return notes.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
