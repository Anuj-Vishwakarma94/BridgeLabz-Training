package com.EmployeePayrollApp.mapper;

import org.springframework.stereotype.Component;

import com.EmployeePayrollApp.dto.EmployeeRequestDTO;
import com.EmployeePayrollApp.dto.EmployeeResponseDTO;
import com.EmployeePayrollApp.entity.Department;
import com.EmployeePayrollApp.entity.Employee;
import com.EmployeePayrollApp.exception.DepartmentNotFoundException;
import com.EmployeePayrollApp.repository.DepartmentRepository;

@Component
public class EmployeeMapper {

    private final DepartmentRepository departmentRepository;

    public EmployeeMapper(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    /**
     * Converts an EmployeeRequestDTO to an Employee entity.
     * Resolves the departmentId to the actual Department entity via JPA.
     */
    public Employee toEntity(EmployeeRequestDTO request) {
        Department department = departmentRepository.findById(request.getDepartmentId())
                .orElseThrow(() -> new DepartmentNotFoundException(
                        "Department not found with id: " + request.getDepartmentId()));

        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        employee.setPhone(request.getPhone());
        employee.setSalary(request.getSalary());
        employee.setDepartment(department);
        return employee;
    }

    /**
     * Converts an Employee entity to an EmployeeResponseDTO.
     * Exposes the department's id for the API response.
     */
    public EmployeeResponseDTO toResponseDTO(Employee employee) {
        return new EmployeeResponseDTO(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getPhone(),
                employee.getSalary(),
                employee.getDepartment().getId()
        );
    }
}
