package com.EmployeePayrollApp.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.EmployeePayrollApp.dto.DepartmentRequestDTO;
import com.EmployeePayrollApp.dto.DepartmentResponseDTO;
import com.EmployeePayrollApp.entity.Department;
import com.EmployeePayrollApp.exception.DepartmentNotFoundException;
import com.EmployeePayrollApp.mapper.DepartmentMapper;
import com.EmployeePayrollApp.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private static final Logger logger = Logger.getLogger(DepartmentServiceImpl.class.getName());

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    @Override
    public DepartmentResponseDTO createDepartment(DepartmentRequestDTO request) {
        logger.info("Creating department with name: " + request.getName());

        Department department = departmentMapper.toEntity(request);
        Department savedDepartment = departmentRepository.save(department);

        logger.info("Department created successfully with ID: " + savedDepartment.getId());

        return departmentMapper.toResponseDTO(savedDepartment);
    }

    @Override
    public List<DepartmentResponseDTO> getAllDepartments() {
        logger.info("Fetching all departments");

        List<DepartmentResponseDTO> departments = departmentRepository.findAll()
                .stream()
                .map(departmentMapper::toResponseDTO)
                .toList();

        logger.info("Departments fetched successfully. Total departments: " + departments.size());

        return departments;
    }

    @Override
    public DepartmentResponseDTO getDepartmentById(Long id) {
        logger.info("Fetching department with ID: " + id);

        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> {
                    logger.warning("Department not found with ID: " + id);
                    return new DepartmentNotFoundException("Department not found with id: " + id);
                });

        logger.info("Department found with ID: " + id);

        return departmentMapper.toResponseDTO(department);
    }

    @Override
    public DepartmentResponseDTO updateDepartment(Long id, DepartmentRequestDTO request) {
        logger.info("Updating department with ID: " + id);

        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> {
                    logger.warning("Department not found with ID: " + id);
                    return new DepartmentNotFoundException("Department not found with id: " + id);
                });

        department.setName(request.getName());

        Department updatedDepartment = departmentRepository.save(department);

        logger.info("Department updated successfully with ID: " + updatedDepartment.getId());

        return departmentMapper.toResponseDTO(updatedDepartment);
    }

    @Override
    public void deleteDepartment(Long id) {
        logger.info("Deleting department with ID: " + id);

        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> {
                    logger.warning("Department not found with ID: " + id);
                    return new DepartmentNotFoundException("Department not found with id: " + id);
                });

        departmentRepository.delete(department);

        logger.info("Department deleted successfully with ID: " + id);
    }
}
