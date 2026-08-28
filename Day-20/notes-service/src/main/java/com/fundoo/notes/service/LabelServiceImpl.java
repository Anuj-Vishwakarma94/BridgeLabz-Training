package com.fundoo.notes.service;

import com.fundoo.notes.dto.response.LabelResponseDTO;
import com.fundoo.notes.entity.Label;
import com.fundoo.notes.exception.ResourceNotFoundException;
import com.fundoo.notes.mapper.LabelMapper;
import com.fundoo.notes.repository.LabelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelServiceImpl implements LabelService {

    private final LabelRepository labelRepository;
    private final LabelMapper labelMapper;

    public LabelServiceImpl(LabelRepository labelRepository, LabelMapper labelMapper) {
        this.labelRepository = labelRepository;
        this.labelMapper = labelMapper;
    }

    @Override
    public LabelResponseDTO createLabel(Long userId, String name) {
        Label label = new Label(name, userId);
        Label saved = labelRepository.save(label);
        return labelMapper.toDTO(saved);
    }

    @Override
    public List<LabelResponseDTO> getMyLabels(Long userId) {
        List<Label> labels = labelRepository.findByUserId(userId);
        return labelMapper.toDTOList(labels);
    }

    @Override
    public LabelResponseDTO updateLabel(Long labelId, String name, Long userId) {
        Label label = labelRepository.findByLabelIdAndUserId(labelId, userId)
                .orElseThrow(() -> new ResourceNotFoundException("Label not found with ID: " + labelId));
        label.setName(name);
        return labelMapper.toDTO(labelRepository.save(label));
    }

    @Override
    public void deleteLabel(Long labelId, Long userId) {
        Label label = labelRepository.findByLabelIdAndUserId(labelId, userId)
                .orElseThrow(() -> new ResourceNotFoundException("Label not found with ID: " + labelId));
        labelRepository.delete(label);
    }
}
