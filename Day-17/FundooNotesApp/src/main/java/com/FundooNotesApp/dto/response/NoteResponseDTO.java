package com.FundooNotesApp.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import com.FundooNotesApp.entity.Label;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteResponseDTO {

    private Long noteId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private boolean pinned;
    private boolean archived;
    private boolean trashed;
    private List<Label> labels;
}

