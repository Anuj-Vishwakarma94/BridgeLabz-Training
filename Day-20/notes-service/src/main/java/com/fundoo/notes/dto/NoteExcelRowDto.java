package com.fundoo.notes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteExcelRowDto {
    private Long noteId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private boolean pinned;
    private boolean archived;
    private boolean trashed;
    private LocalDateTime reminderAt;
    private String labels;
}
