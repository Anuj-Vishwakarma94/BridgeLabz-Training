package com.EmployeePayrollApp.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeePayrollApp.dto.DepartmentRequestDTO;
import com.EmployeePayrollApp.dto.DepartmentResponseDTO;
import com.EmployeePayrollApp.service.DepartmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/departments")
@Tag(name = "Department Management", description = "Endpoints for creating, retrieving, updating, and deleting departments.")
public class DepartmentController {

    private static final Logger logger = Logger.getLogger(DepartmentController.class.getName());

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    @Operation(summary = "Create Department", description = "Creates a new department record.")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Department created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid request payload")
    })
    public ResponseEntity<DepartmentResponseDTO> createDepartment(@Valid @RequestBody DepartmentRequestDTO request) {
        logger.info("REST request to create department: " + request.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.createDepartment(request));
    }

    @GetMapping
    @Operation(summary = "Get All Departments", description = "Retrieves a list of all departments.")
    @ApiResponse(responseCode = "200", description = "List of departments fetched successfully")
    public ResponseEntity<List<DepartmentResponseDTO>> getAllDepartments() {
        logger.info("REST request to get all departments");
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Department by ID", description = "Fetches details of a specific department by its unique ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Department found"),
        @ApiResponse(responseCode = "404", description = "Department not found")
    })
    public ResponseEntity<DepartmentResponseDTO> getDepartmentById(
            @Parameter(description = "ID of the department to be retrieved", example = "1") @PathVariable Long id) {
        logger.info("REST request to get department by ID: " + id);
        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Department", description = "Updates an existing department's details by ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Department updated successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid request payload"),
        @ApiResponse(responseCode = "404", description = "Department not found")
    })
    public ResponseEntity<DepartmentResponseDTO> updateDepartment(
            @Parameter(description = "ID of the department to be updated", example = "1") @PathVariable Long id,
            @Valid @RequestBody DepartmentRequestDTO request) {
        logger.info("REST request to update department ID: " + id);
        return ResponseEntity.ok(departmentService.updateDepartment(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Department", description = "Deletes a department record by ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Department deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Department not found")
    })
    public ResponseEntity<Void> deleteDepartment(
            @Parameter(description = "ID of the department to be deleted", example = "1") @PathVariable Long id) {
        logger.info("REST request to delete department ID: " + id);
        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }
}
