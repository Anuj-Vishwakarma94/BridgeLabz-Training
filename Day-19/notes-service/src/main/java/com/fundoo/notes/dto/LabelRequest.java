package com.fundoo.notes.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LabelRequest {
    @NotBlank(message = "Label name is required")
    private String name;
}
