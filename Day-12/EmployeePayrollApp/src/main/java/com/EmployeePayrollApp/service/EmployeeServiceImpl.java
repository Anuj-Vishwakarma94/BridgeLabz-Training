package com.EmployeePayrollApp.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

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

    private static final Logger logger = Logger.getLogger(EmployeeServiceImpl.class.getName());

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
        logger.info("Creating employee with email: " + request.getEmail());

        Department department = departmentRepository.findById(request.getDepartmentId())
                .orElseThrow(() -> {
                    logger.warning("Department not found with ID: " + request.getDepartmentId());
                    return new DepartmentNotFoundException("Department not found with id: " + request.getDepartmentId());
                });

        Employee employee = employeeMapper.toEntity(request);
        employee.setDepartment(department);

        Employee savedEmployee = employeeRepository.save(employee);

        logger.info("Employee created successfully with ID: " + savedEmployee.getId());

        return employeeMapper.toResponseDTO(savedEmployee);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeResponseDTO> getAllEmployees() {
        logger.info("Fetching all employees");

        List<EmployeeResponseDTO> employees = employeeRepository.findAll()
                .stream()
                .map(employeeMapper::toResponseDTO)
                .toList();

        logger.info("Employees fetched successfully. Total employees: " + employees.size());

        return employees;
    }

    @Override
    @Transactional(readOnly = true)
    public EmployeeResponseDTO getEmployeeById(Long id) {
        logger.info("Fetching employee with ID: " + id);

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> {
                    logger.warning("Employee not found with ID: " + id);
                    return new EmployeeNotFoundException("Employee not found with id: " + id);
                });

        logger.info("Employee found with ID: " + id);

        return employeeMapper.toResponseDTO(employee);
    }

    @Override
    public EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO request) {
        logger.info("Updating employee with ID: " + id);

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> {
                    logger.warning("Employee not found with ID: " + id);
                    return new EmployeeNotFoundException("Employee not found with id: " + id);
                });

        Department department = departmentRepository.findById(request.getDepartmentId())
                .orElseThrow(() -> {
                    logger.warning("Department not found with ID: " + request.getDepartmentId());
                    return new DepartmentNotFoundException("Department not found with id: " + request.getDepartmentId());
                });

        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        employee.setPhone(request.getPhone());
        employee.setSalary(request.getSalary());
        employee.setDepartment(department);

        Employee updatedEmployee = employeeRepository.save(employee);

        logger.info("Employee updated successfully with ID: " + updatedEmployee.getId());

        return employeeMapper.toResponseDTO(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        logger.info("Deleting employee with ID: " + id);

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> {
                    logger.warning("Employee not found with ID: " + id);
                    return new EmployeeNotFoundException("Employee not found with id: " + id);
                });

        employeeRepository.delete(employee);

        logger.info("Employee deleted successfully with ID: " + id);
    }

    // Pagination for all employees
    @Override
    @Transactional(readOnly = true)
    public Page<EmployeeResponseDTO> getEmployeesPaginated(int page, int size, String sortBy) {
        logger.info("Fetching paginated employees: page=" + page + ", size=" + size + ", sortBy=" + sortBy);

        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(sortBy).ascending());
        Page<EmployeeResponseDTO> employees = employeeRepository.findAll(pageRequest)
                .map(employeeMapper::toResponseDTO);

        logger.info("Employees fetched successfully. Total employees: " + employees.getTotalElements());

        return employees;
    }

    // Search employees by name keyword with pagination
    @Override
    @Transactional(readOnly = true)
    public Page<EmployeeResponseDTO> searchEmployees(String keyword, int page, int size) {
        logger.info("Searching employees with keyword: '" + keyword + "', page=" + page + ", size=" + size);

        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("name").ascending());
        Page<EmployeeResponseDTO> employees = employeeRepository.findByNameContainingIgnoreCase(keyword, pageRequest)
                .map(employeeMapper::toResponseDTO);

        logger.info("Employee search completed. Total employees found: " + employees.getTotalElements());

        return employees;
    }

    // Get employees by department ID
    @Override
    @Transactional(readOnly = true)
    public List<EmployeeResponseDTO> getEmployeesByDepartment(Long deptId) {
        logger.info("Fetching employees for department ID: " + deptId);

        List<EmployeeResponseDTO> employees = employeeRepository.findByDepartmentId(deptId)
                .stream()
                .map(employeeMapper::toResponseDTO)
                .toList();

        logger.info("Department employees fetched successfully. Total employees: " + employees.size());

        return employees;
    }

    // Get employees by department ID with pagination
    @Override
    @Transactional(readOnly = true)
    public Page<EmployeeResponseDTO> getEmployeesByDepartmentPaginated(Long deptId, int page, int size) {
        logger.info("Fetching paginated employees for department ID: " + deptId + ", page=" + page + ", size=" + size);

        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("name").ascending());
        Page<EmployeeResponseDTO> employees = employeeRepository.findByDepartmentId(deptId, pageRequest)
                .map(employeeMapper::toResponseDTO);

        logger.info("Paginated department employees fetched successfully. Total employees: " + employees.getTotalElements());

        return employees;
    }

    // Get employees with salary above threshold using custom @Query with pagination
    @Override
    @Transactional(readOnly = true)
    public Page<EmployeeResponseDTO> getHighEarners(BigDecimal minSalary, int page, int size) {
        logger.info("Fetching employees with minimum salary: " + minSalary);

        PageRequest pageRequest = PageRequest.of(page, size);
        Page<EmployeeResponseDTO> employees = employeeRepository.findHighEarners(minSalary, pageRequest)
                .map(employeeMapper::toResponseDTO);

        logger.info("Salary search completed. Total employees found: " + employees.getTotalElements());

        return employees;
    }

    // Get all employees sorted by field (e.g. salary) and direction (asc/desc)
    @Override
    @Transactional(readOnly = true)
    public List<EmployeeResponseDTO> getEmployeesSorted(String sortBy, String sortDir) {
        logger.info("Fetching employees sorted by: " + sortBy + " (" + sortDir + ")");

        String property = (sortBy == null || sortBy.isBlank()) ? "salary" : sortBy;
        Sort.Direction direction = "desc".equalsIgnoreCase(sortDir) ? Sort.Direction.DESC : Sort.Direction.ASC;
        List<EmployeeResponseDTO> employees = employeeRepository.findAll(Sort.by(direction, property))
                .stream()
                .map(employeeMapper::toResponseDTO)
                .toList();

        logger.info("Sorted employees fetched successfully. Total employees: " + employees.size());

        return employees;
    }
}
