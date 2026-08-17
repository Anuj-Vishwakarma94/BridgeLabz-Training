package com.EmployeePayrollApp.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;

import com.EmployeePayrollApp.dto.EmployeeRequestDTO;
import com.EmployeePayrollApp.dto.EmployeeResponseDTO;

public interface EmployeeService {

    EmployeeResponseDTO createEmployee(EmployeeRequestDTO request);

    List<EmployeeResponseDTO> getAllEmployees();

    EmployeeResponseDTO getEmployeeById(Long id);

    EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO request);

    void deleteEmployee(Long id);

    // ── Pagination ───────────────────────────────────────────────────────────

    /** Returns a paginated, sorted list of all employees. */
    Page<EmployeeResponseDTO> getEmployeesPaginated(int page, int size, String sortBy);

    /** Returns a paginated list of employees whose name contains the keyword. */
    Page<EmployeeResponseDTO> searchEmployees(String keyword, int page, int size);

    // ── Custom Query Methods ─────────────────────────────────────────────────

    /** Returns all employees belonging to a specific department. */
    List<EmployeeResponseDTO> getEmployeesByDepartment(Long deptId);

    /** Returns paginated employees in a department. */
    Page<EmployeeResponseDTO> getEmployeesByDepartmentPaginated(Long deptId, int page, int size);

    /** Returns paginated employees earning above the given salary threshold. */
    Page<EmployeeResponseDTO> getHighEarners(BigDecimal minSalary, int page, int size);

    /** Returns all employees sorted by specified field (e.g., salary, name) and direction (asc/desc). */
    List<EmployeeResponseDTO> getEmployeesSorted(String sortBy, String sortDir);
}
