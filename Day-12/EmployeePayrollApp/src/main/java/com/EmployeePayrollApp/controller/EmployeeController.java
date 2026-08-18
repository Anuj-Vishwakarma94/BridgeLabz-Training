package com.EmployeePayrollApp.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeePayrollApp.dto.EmployeeRequestDTO;
import com.EmployeePayrollApp.dto.EmployeeResponseDTO;
import com.EmployeePayrollApp.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
@Tag(name = "Employee Management", description = "Endpoints for creating, fetching, updating, and deleting employees as well as searching and paginating records.")
public class EmployeeController {

    private static final Logger logger = Logger.getLogger(EmployeeController.class.getName());

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Create a new employee
    @PostMapping
    @Operation(summary = "Create Employee", description = "Creates a new employee record and assigns them to a department.")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Employee created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid request payload"),
        @ApiResponse(responseCode = "404", description = "Department not found")
    })
    public ResponseEntity<EmployeeResponseDTO> createEmployee(@Valid @RequestBody EmployeeRequestDTO request) {
        logger.info("REST request to create employee: " + request.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(request));
    }

    // Get all employees
    @GetMapping
    @Operation(summary = "Get All Employees", description = "Retrieves a list of all employees.")
    @ApiResponse(responseCode = "200", description = "List of employees fetched successfully")
    public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployees() {
        logger.info("REST request to get all employees");
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    // Get employee by ID
    @GetMapping("/{id}")
    @Operation(summary = "Get Employee by ID", description = "Fetches details of a specific employee by their unique ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Employee found"),
        @ApiResponse(responseCode = "404", description = "Employee not found")
    })
    public ResponseEntity<EmployeeResponseDTO> getEmployeeById(
            @Parameter(description = "ID of the employee to be retrieved", example = "1") @PathVariable Long id) {
        logger.info("REST request to get employee by ID: " + id);
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    // Update employee by ID
    @PutMapping("/{id}")
    @Operation(summary = "Update Employee", description = "Updates an existing employee's details by ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Employee updated successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid request payload"),
        @ApiResponse(responseCode = "404", description = "Employee or Department not found")
    })
    public ResponseEntity<EmployeeResponseDTO> updateEmployee(
            @Parameter(description = "ID of the employee to be updated", example = "1") @PathVariable Long id,
            @Valid @RequestBody EmployeeRequestDTO request) {
        logger.info("REST request to update employee ID: " + id);
        return ResponseEntity.ok(employeeService.updateEmployee(id, request));
    }

    // Delete employee by ID
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Employee", description = "Deletes an employee record by ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Employee deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Employee not found")
    })
    public ResponseEntity<Void> deleteEmployee(
            @Parameter(description = "ID of the employee to be deleted", example = "1") @PathVariable Long id) {
        logger.info("REST request to delete employee ID: " + id);
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    // Get paginated and sorted employees
    @GetMapping("/paginated")
    @Operation(summary = "Get Employees (Paginated & Sorted)", description = "Retrieves a page of employees sorted by specified field.")
    @ApiResponse(responseCode = "200", description = "Paginated list of employees fetched successfully")
    public ResponseEntity<Page<EmployeeResponseDTO>> getEmployeesPaginated(
            @Parameter(description = "Page index (0-based)", example = "0") @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Page size", example = "5") @RequestParam(defaultValue = "5") int size,
            @Parameter(description = "Field to sort by", example = "name") @RequestParam(defaultValue = "name") String sortBy) {
        logger.info("REST request to get paginated employees: page=" + page + ", size=" + size + ", sortBy=" + sortBy);
        return ResponseEntity.ok(employeeService.getEmployeesPaginated(page, size, sortBy));
    }

    // Search employees by name keyword with pagination
    @GetMapping("/search")
    @Operation(summary = "Search Employees by Keyword", description = "Searches for employees by name containing the keyword (case-insensitive) with pagination.")
    @ApiResponse(responseCode = "200", description = "SearchResult fetched successfully")
    public ResponseEntity<Page<EmployeeResponseDTO>> searchEmployees(
            @Parameter(description = "Keyword to search in employee names", example = "John") @RequestParam String keyword,
            @Parameter(description = "Page index (0-based)", example = "0") @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Page size", example = "5") @RequestParam(defaultValue = "5") int size) {
        logger.info("REST request to search employees with keyword: " + keyword);
        return ResponseEntity.ok(employeeService.searchEmployees(keyword, page, size));
    }

    // Get employees by department ID
    @GetMapping("/department/{deptId}")
    @Operation(summary = "Get Employees by Department ID", description = "Retrieves all employees belonging to a specific department.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Employees fetched successfully"),
        @ApiResponse(responseCode = "404", description = "Department not found")
    })
    public ResponseEntity<List<EmployeeResponseDTO>> getEmployeesByDepartment(
            @Parameter(description = "Department ID", example = "1") @PathVariable Long deptId) {
        logger.info("REST request to get employees for department ID: " + deptId);
        return ResponseEntity.ok(employeeService.getEmployeesByDepartment(deptId));
    }

    // Get employees by department ID with pagination
    @GetMapping("/department/{deptId}/paginated")
    @Operation(summary = "Get Employees by Department ID (Paginated)", description = "Retrieves a paginated list of employees in a department.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Paginated employees fetched successfully"),
        @ApiResponse(responseCode = "404", description = "Department not found")
    })
    public ResponseEntity<Page<EmployeeResponseDTO>> getEmployeesByDepartmentPaginated(
            @Parameter(description = "Department ID", example = "1") @PathVariable Long deptId,
            @Parameter(description = "Page index (0-based)", example = "0") @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Page size", example = "5") @RequestParam(defaultValue = "5") int size) {
        logger.info("REST request to get paginated employees for department ID: " + deptId);
        return ResponseEntity.ok(employeeService.getEmployeesByDepartmentPaginated(deptId, page, size));
    }

    // Get employees earning above minimum salary using custom native @Query with pagination
    @GetMapping("/high-earners")
    @Operation(summary = "Get High Earning Employees", description = "Retrieves employees earning more than the specified minimum salary.")
    @ApiResponse(responseCode = "200", description = "High earners fetched successfully")
    public ResponseEntity<Page<EmployeeResponseDTO>> getHighEarners(
            @Parameter(description = "Minimum salary threshold", example = "50000.00") @RequestParam BigDecimal minSalary,
            @Parameter(description = "Page index (0-based)", example = "0") @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Page size", example = "5") @RequestParam(defaultValue = "5") int size) {
        logger.info("REST request to get high earners with minSalary: " + minSalary);
        return ResponseEntity.ok(employeeService.getHighEarners(minSalary, page, size));
    }

    // Get employees sorted by field (e.g. GET /api/employees/sorted?sortBy=salary&sortDir=asc)
    @GetMapping("/sorted")
    @Operation(summary = "Get Employees Sorted", description = "Retrieves employees sorted by a given field and direction (asc/desc).")
    @ApiResponse(responseCode = "200", description = "Sorted employees list fetched successfully")
    public ResponseEntity<List<EmployeeResponseDTO>> getEmployeesSorted(
            @Parameter(description = "Field to sort by (e.g. salary, name)", example = "salary") @RequestParam(defaultValue = "salary") String sortBy,
            @Parameter(description = "Sort direction (asc or desc)", example = "asc") @RequestParam(defaultValue = "asc") String sortDir) {
        logger.info("REST request to get employees sorted by: " + sortBy + " (" + sortDir + ")");
        return ResponseEntity.ok(employeeService.getEmployeesSorted(sortBy, sortDir));
    }
}
