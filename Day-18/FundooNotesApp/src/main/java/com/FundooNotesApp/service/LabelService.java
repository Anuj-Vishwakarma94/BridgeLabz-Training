package com.FundooNotesApp.service;

import java.util.List;

import com.FundooNotesApp.dto.response.LabelResponseDTO;

public interface LabelService {

    LabelResponseDTO createLabel(Long userId, String name);

    List<LabelResponseDTO> getLabels(Long userId);

    LabelResponseDTO renameLabel(Long labelId, Long userId, String newName);

    boolean deleteLabel(Long labelId, Long userId);
}
