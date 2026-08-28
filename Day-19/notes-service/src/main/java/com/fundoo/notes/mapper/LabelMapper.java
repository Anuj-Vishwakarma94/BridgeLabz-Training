package com.fundoo.notes.mapper;

import com.fundoo.notes.dto.response.LabelResponseDTO;
import com.fundoo.notes.entity.Label;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LabelMapper {

    public LabelResponseDTO toDTO(Label label) {
        if (label == null) return null;
        return new LabelResponseDTO(label.getLabelId(), label.getName());
    }

    public List<LabelResponseDTO> toDTOList(List<Label> labels) {
        if (labels == null) return List.of();
        return labels.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
