package com.EmployeePayrollApp.controller;

import java.math.BigDecimal;
import java.util.List;

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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Create a new employee
    @PostMapping
    public ResponseEntity<EmployeeResponseDTO> createEmployee(@Valid @RequestBody EmployeeRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(request));
    }

    // Get all employees
    @GetMapping
    public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    // Get employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    // Update employee by ID
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> updateEmployee(@PathVariable Long id,
            @Valid @RequestBody EmployeeRequestDTO request) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, request));
    }

    // Delete employee by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    // Get paginated and sorted employees
    @GetMapping("/paginated")
    public ResponseEntity<Page<EmployeeResponseDTO>> getEmployeesPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sortBy) {
        return ResponseEntity.ok(employeeService.getEmployeesPaginated(page, size, sortBy));
    }

    // Search employees by name keyword with pagination
    @GetMapping("/search")
    public ResponseEntity<Page<EmployeeResponseDTO>> searchEmployees(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(employeeService.searchEmployees(keyword, page, size));
    }

    // Get employees by department ID
    @GetMapping("/department/{deptId}")
    public ResponseEntity<List<EmployeeResponseDTO>> getEmployeesByDepartment(@PathVariable Long deptId) {
        return ResponseEntity.ok(employeeService.getEmployeesByDepartment(deptId));
    }

    // Get employees by department ID with pagination
    @GetMapping("/department/{deptId}/paginated")
    public ResponseEntity<Page<EmployeeResponseDTO>> getEmployeesByDepartmentPaginated(
            @PathVariable Long deptId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(employeeService.getEmployeesByDepartmentPaginated(deptId, page, size));
    }

    // Get employees earning above minimum salary using custom native @Query with pagination
    @GetMapping("/high-earners")
    public ResponseEntity<Page<EmployeeResponseDTO>> getHighEarners(
            @RequestParam BigDecimal minSalary,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(employeeService.getHighEarners(minSalary, page, size));
    }

    // Get employees sorted by field (e.g. GET /api/employees/sorted?sortBy=salary&sortDir=asc)
    @GetMapping("/sorted")
    public ResponseEntity<List<EmployeeResponseDTO>> getEmployeesSorted(
            @RequestParam(defaultValue = "salary") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {
        return ResponseEntity.ok(employeeService.getEmployeesSorted(sortBy, sortDir));
    }
}
