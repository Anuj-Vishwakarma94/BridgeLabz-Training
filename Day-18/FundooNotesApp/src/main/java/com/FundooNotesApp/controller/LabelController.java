package com.FundooNotesApp.controller;

import java.util.List;

import com.FundooNotesApp.dto.response.ApiResponse;
import jakarta.validation.Valid;
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
    public ResponseEntity<ApiResponse<LabelResponseDTO>> createLabel(@Valid @RequestBody LabelRequest request) {
        LabelResponseDTO label = labelService.createLabel(currentUserId(), request.getName());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Label created successfully", label));
    }

    /** GET /labels – list all labels owned by the current user */
    @GetMapping
    public ResponseEntity<ApiResponse<List<LabelResponseDTO>>> getLabels() {
        List<LabelResponseDTO> labels = labelService.getLabels(currentUserId());
        return ResponseEntity.ok(ApiResponse.success("Fetched user labels successfully", labels));
    }

    /** PUT /labels/{id} – rename a label */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<LabelResponseDTO>> renameLabel(@PathVariable Long id, @Valid @RequestBody LabelRequest request) {
        LabelResponseDTO updated = labelService.renameLabel(id, currentUserId(), request.getName());
        return ResponseEntity.ok(ApiResponse.success("Label renamed successfully", updated));
    }

    /** DELETE /labels/{id} – delete a label */
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteLabel(@PathVariable Long id) {
        labelService.deleteLabel(id, currentUserId());
        return ResponseEntity.ok(ApiResponse.success("Label deleted successfully", null));
    }
}
