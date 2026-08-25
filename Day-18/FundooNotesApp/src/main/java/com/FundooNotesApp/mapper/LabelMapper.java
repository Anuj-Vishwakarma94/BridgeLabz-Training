package com.FundooNotesApp.mapper;

import com.FundooNotesApp.dto.response.LabelResponseDTO;
import com.FundooNotesApp.entity.Label;
import org.springframework.stereotype.Component;

@Component
public class LabelMapper {

    public LabelResponseDTO toResponseDTO(Label label) {
        if (label == null) {
            return null;
        }
        return new LabelResponseDTO(
                label.getLabelId(),
                label.getName()
        );
    }
}
