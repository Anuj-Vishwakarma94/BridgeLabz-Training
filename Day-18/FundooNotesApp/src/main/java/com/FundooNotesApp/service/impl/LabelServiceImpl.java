package com.FundooNotesApp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.FundooNotesApp.dto.response.LabelResponseDTO;
import com.FundooNotesApp.entity.Label;
import com.FundooNotesApp.entity.User;
import com.FundooNotesApp.exception.FundooAppException;
import com.FundooNotesApp.exception.ResourceNotFoundException;
import com.FundooNotesApp.mapper.LabelMapper;
import com.FundooNotesApp.repository.LabelRepository;
import com.FundooNotesApp.repository.UserRepository;
import com.FundooNotesApp.service.LabelService;

@Service
public class LabelServiceImpl implements LabelService {

    private final LabelRepository labelRepository;
    private final UserRepository userRepository;
    private final LabelMapper labelMapper;

    public LabelServiceImpl(LabelRepository labelRepository, UserRepository userRepository, LabelMapper labelMapper) {
        this.labelRepository = labelRepository;
        this.userRepository = userRepository;
        this.labelMapper = labelMapper;
    }

    @Override
    public LabelResponseDTO createLabel(Long userId, String name) {
        User owner = findUser(userId);
        if (labelRepository.existsByNameAndOwner(name, owner)) {
            throw new FundooAppException("Label '" + name + "' already exists");
        }
        Label label = labelRepository.save(new Label(name, owner));
        return labelMapper.toResponseDTO(label);
    }

    @Override
    public List<LabelResponseDTO> getLabels(Long userId) {
        User owner = findUser(userId);
        return labelRepository.findByOwner(owner)
                .stream()
                .map(labelMapper::toResponseDTO)
                .toList();
    }

    @Override
    public LabelResponseDTO renameLabel(Long labelId, Long userId, String newName) {
        User owner = findUser(userId);
        Label label = labelRepository.findByLabelIdAndOwner(labelId, owner)
                .orElseThrow(() -> new ResourceNotFoundException("Label with ID " + labelId + " not found or unauthorized"));
        label.setName(newName);
        return labelMapper.toResponseDTO(labelRepository.save(label));
    }

    @Override
    public boolean deleteLabel(Long labelId, Long userId) {
        User owner = findUser(userId);
        Label label = labelRepository.findByLabelIdAndOwner(labelId, owner)
                .orElseThrow(() -> new ResourceNotFoundException("Label with ID " + labelId + " not found or unauthorized"));
        labelRepository.delete(label);
        return true;
    }

    private User findUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with ID " + userId + " not found"));
    }
}
