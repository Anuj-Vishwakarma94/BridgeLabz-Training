package com.EmployeePayrollApp.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.EmployeePayrollApp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Find employees by department ID
    List<Employee> findByDepartmentId(Long departmentId);

    // Find employees by department ID with pagination
    Page<Employee> findByDepartmentId(Long departmentId, Pageable pageable);

    // Search employees by name (case-insensitive) with pagination
    Page<Employee> findByNameContainingIgnoreCase(String name, Pageable pageable);

    // Custom SQL query to find employees with salary above threshold with pagination
    @Query(value = "SELECT * FROM employee WHERE salary > :minSalary", 
           countQuery = "SELECT COUNT(*) FROM employee WHERE salary > :minSalary", 
           nativeQuery = true)
    Page<Employee> findHighEarners(@Param("minSalary") BigDecimal minSalary, Pageable pageable);
}
