package com.FundooNotesApp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FundooNotesApp.dto.LabelRequest;
import com.FundooNotesApp.dto.response.LabelResponseDTO;
import com.FundooNotesApp.security.CustomUserDetails;
import com.FundooNotesApp.service.LabelService;

@RestController
@RequestMapping({"/labels", "/api/labels"})
public class LabelController {

    private final LabelService labelService;

    public LabelController(LabelService labelService) {
        this.labelService = labelService;
    }

    private Long currentUserId() {
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        return userDetails.getUserId();
    }

    /** POST /labels – create a new label */
    @PostMapping
    public ResponseEntity<LabelResponseDTO> createLabel(@RequestBody LabelRequest request) {
        try {
            LabelResponseDTO label = labelService.createLabel(currentUserId(), request.getName());
            return ResponseEntity.status(HttpStatus.CREATED).body(label);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /** GET /labels – list all labels owned by the current user */
    @GetMapping
    public List<LabelResponseDTO> getLabels() {
        return labelService.getLabels(currentUserId());
    }

    /** PUT /labels/{id} – rename a label */
    @PutMapping("/{id}")
    public ResponseEntity<LabelResponseDTO> renameLabel(@PathVariable Long id, @RequestBody LabelRequest request) {
        try {
            LabelResponseDTO updated = labelService.renameLabel(id, currentUserId(), request.getName());
            return ResponseEntity.ok(updated);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /** DELETE /labels/{id} – delete a label */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLabel(@PathVariable Long id) {
        boolean deleted = labelService.deleteLabel(id, currentUserId());
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
