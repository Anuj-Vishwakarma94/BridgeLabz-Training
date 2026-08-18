package com.EmployeePayrollApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EmployeePayrollApp.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    /** Derived query: find departments whose name contains the keyword (case-insensitive). */
    List<Department> findByNameContainingIgnoreCase(String name);
}
