package com.fundoo.notes.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

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
    private LocalDateTime reminderAt;
    private boolean reminderSent;
    private List<LabelResponseDTO> labels;
}
