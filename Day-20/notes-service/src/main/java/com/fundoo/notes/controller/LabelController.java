package com.fundoo.notes.controller;

import com.fundoo.notes.dto.LabelRequest;
import com.fundoo.notes.dto.response.ApiResponse;
import com.fundoo.notes.dto.response.LabelResponseDTO;
import com.fundoo.notes.security.CustomUserDetails;
import com.fundoo.notes.service.LabelService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping
    public ResponseEntity<ApiResponse<LabelResponseDTO>> createLabel(@Valid @RequestBody LabelRequest request) {
        LabelResponseDTO label = labelService.createLabel(currentUserId(), request.getName());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Label created successfully", label));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<LabelResponseDTO>>> getMyLabels() {
        List<LabelResponseDTO> labels = labelService.getMyLabels(currentUserId());
        return ResponseEntity.ok(ApiResponse.success("Fetched labels successfully", labels));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<LabelResponseDTO>> updateLabel(@PathVariable Long id, @Valid @RequestBody LabelRequest request) {
        LabelResponseDTO label = labelService.updateLabel(id, request.getName(), currentUserId());
        return ResponseEntity.ok(ApiResponse.success("Label updated successfully", label));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteLabel(@PathVariable Long id) {
        labelService.deleteLabel(id, currentUserId());
        return ResponseEntity.ok(ApiResponse.success("Label deleted successfully", null));
    }
}
