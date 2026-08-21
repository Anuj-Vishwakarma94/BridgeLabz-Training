package com.FundooNotesApp.dto.response;

import java.time.LocalDateTime;

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
}
