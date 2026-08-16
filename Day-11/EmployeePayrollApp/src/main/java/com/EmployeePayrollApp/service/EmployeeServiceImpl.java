package com.EmployeePayrollApp.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.EmployeePayrollApp.dto.EmployeeRequestDTO;
import com.EmployeePayrollApp.dto.EmployeeResponseDTO;
import com.EmployeePayrollApp.entity.Department;
import com.EmployeePayrollApp.entity.Employee;
import com.EmployeePayrollApp.exception.DepartmentNotFoundException;
import com.EmployeePayrollApp.exception.EmployeeNotFoundException;
import com.EmployeePayrollApp.mapper.EmployeeMapper;
import com.EmployeePayrollApp.repository.DepartmentRepository;
import com.EmployeePayrollApp.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final DepartmentRepository departmentRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper,
            DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO request) {
        Employee employee = employeeMapper.toEntity(request);
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.toResponseDTO(savedEmployee);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeResponseDTO> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::toResponseDTO)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public EmployeeResponseDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
        return employeeMapper.toResponseDTO(employee);
    }

    @Override
    public EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO request) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));

        Department department = departmentRepository.findById(request.getDepartmentId())
                .orElseThrow(() -> new DepartmentNotFoundException(
                        "Department not found with id: " + request.getDepartmentId()));

        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        employee.setPhone(request.getPhone());
        employee.setSalary(request.getSalary());
        employee.setDepartment(department);

        Employee updatedEmployee = employeeRepository.save(employee);
        return employeeMapper.toResponseDTO(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
        employeeRepository.delete(employee);
    }

    // Pagination for all employees
    @Override
    @Transactional(readOnly = true)
    public Page<EmployeeResponseDTO> getEmployeesPaginated(int page, int size, String sortBy) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(sortBy).ascending());
        return employeeRepository.findAll(pageRequest)
                .map(employeeMapper::toResponseDTO);
    }

    // Search employees by name keyword with pagination
    @Override
    @Transactional(readOnly = true)
    public Page<EmployeeResponseDTO> searchEmployees(String keyword, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("name").ascending());
        return employeeRepository.findByNameContainingIgnoreCase(keyword, pageRequest)
                .map(employeeMapper::toResponseDTO);
    }

    // Get employees by department ID
    @Override
    @Transactional(readOnly = true)
    public List<EmployeeResponseDTO> getEmployeesByDepartment(Long deptId) {
        return employeeRepository.findByDepartmentId(deptId)
                .stream()
                .map(employeeMapper::toResponseDTO)
                .toList();
    }

    // Get employees by department ID with pagination
    @Override
    @Transactional(readOnly = true)
    public Page<EmployeeResponseDTO> getEmployeesByDepartmentPaginated(Long deptId, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("name").ascending());
        return employeeRepository.findByDepartmentId(deptId, pageRequest)
                .map(employeeMapper::toResponseDTO);
    }

    // Get employees with salary above threshold using custom @Query with pagination
    @Override
    @Transactional(readOnly = true)
    public Page<EmployeeResponseDTO> getHighEarners(BigDecimal minSalary, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return employeeRepository.findHighEarners(minSalary, pageRequest)
                .map(employeeMapper::toResponseDTO);
    }
}
