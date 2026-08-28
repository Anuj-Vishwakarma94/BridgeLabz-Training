package com.fundoo.notes.service;

import com.fundoo.notes.dto.response.LabelResponseDTO;

import java.util.List;

public interface LabelService {
    LabelResponseDTO createLabel(Long userId, String name);
    List<LabelResponseDTO> getMyLabels(Long userId);
    LabelResponseDTO updateLabel(Long labelId, String name, Long userId);
    void deleteLabel(Long labelId, Long userId);
}
