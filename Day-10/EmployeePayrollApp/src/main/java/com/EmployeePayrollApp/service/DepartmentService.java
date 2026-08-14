package com.EmployeePayrollApp.service;

import java.util.List;

import com.EmployeePayrollApp.dto.DepartmentRequestDTO;
import com.EmployeePayrollApp.dto.DepartmentResponseDTO;

public interface DepartmentService {

    DepartmentResponseDTO createDepartment(DepartmentRequestDTO request);

    List<DepartmentResponseDTO> getAllDepartments();

    DepartmentResponseDTO getDepartmentById(Long id);

    DepartmentResponseDTO updateDepartment(Long id, DepartmentRequestDTO request);

    void deleteDepartment(Long id);
}
