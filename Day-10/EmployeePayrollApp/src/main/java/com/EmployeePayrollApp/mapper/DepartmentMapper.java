package com.EmployeePayrollApp.mapper;

import org.springframework.stereotype.Component;

import com.EmployeePayrollApp.dto.DepartmentRequestDTO;
import com.EmployeePayrollApp.dto.DepartmentResponseDTO;
import com.EmployeePayrollApp.entity.Department;

@Component
public class DepartmentMapper {

    public Department toEntity(DepartmentRequestDTO request) {
        Department department = new Department();
        department.setName(request.getName());
        return department;
    }

    public DepartmentResponseDTO toResponseDTO(Department department) {
        return new DepartmentResponseDTO(department.getId(), department.getName());
    }
}
