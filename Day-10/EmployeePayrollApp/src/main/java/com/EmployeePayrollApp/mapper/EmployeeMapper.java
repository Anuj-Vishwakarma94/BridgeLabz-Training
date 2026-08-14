package com.EmployeePayrollApp.mapper;

import org.springframework.stereotype.Component;

import com.EmployeePayrollApp.dto.EmployeeRequestDTO;
import com.EmployeePayrollApp.dto.EmployeeResponseDTO;
import com.EmployeePayrollApp.entity.Employee;

@Component
public class EmployeeMapper {

    public Employee toEntity(EmployeeRequestDTO request) {
        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        employee.setPhone(request.getPhone());
        employee.setSalary(request.getSalary());
        employee.setDepartmentId(request.getDepartmentId());
        return employee;
    }

    public EmployeeResponseDTO toResponseDTO(Employee employee) {
        return new EmployeeResponseDTO(
            employee.getId(),
            employee.getName(),
            employee.getEmail(),
            employee.getPhone(),
            employee.getSalary(),
            employee.getDepartmentId()
        );
    }
}
