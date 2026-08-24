package com.FundooNotesApp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.FundooNotesApp.dto.response.LabelResponseDTO;
import com.FundooNotesApp.entity.Label;
import com.FundooNotesApp.entity.User;
import com.FundooNotesApp.repository.LabelRepository;
import com.FundooNotesApp.repository.UserRepository;
import com.FundooNotesApp.service.LabelService;

@Service
public class LabelServiceImpl implements LabelService {

    private final LabelRepository labelRepository;
    private final UserRepository userRepository;

    public LabelServiceImpl(LabelRepository labelRepository, UserRepository userRepository) {
        this.labelRepository = labelRepository;
        this.userRepository = userRepository;
    }

    @Override
    public LabelResponseDTO createLabel(Long userId, String name) {
        User owner = findUser(userId);
        if (labelRepository.existsByNameAndOwner(name, owner)) {
            throw new IllegalArgumentException("Label '" + name + "' already exists");
        }
        Label label = labelRepository.save(new Label(name, owner));
        return toDTO(label);
    }

    @Override
    public List<LabelResponseDTO> getLabels(Long userId) {
        User owner = findUser(userId);
        return labelRepository.findByOwner(owner)
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public LabelResponseDTO renameLabel(Long labelId, Long userId, String newName) {
        User owner = findUser(userId);
        Label label = labelRepository.findByLabelIdAndOwner(labelId, owner)
                .orElseThrow(() -> new IllegalArgumentException("Label not found or unauthorized"));
        label.setName(newName);
        return toDTO(labelRepository.save(label));
    }

    @Override
    public boolean deleteLabel(Long labelId, Long userId) {
        User owner = findUser(userId);
        return labelRepository.findByLabelIdAndOwner(labelId, owner)
                .map(label -> {
                    labelRepository.delete(label);
                    return true;
                })
                .orElse(false);
    }

    private User findUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    private LabelResponseDTO toDTO(Label label) {
        return new LabelResponseDTO(label.getLabelId(), label.getName());
    }
}
