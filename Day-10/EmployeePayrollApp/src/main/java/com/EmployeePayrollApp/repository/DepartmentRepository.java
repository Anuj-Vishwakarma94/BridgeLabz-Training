package com.EmployeePayrollApp.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.EmployeePayrollApp.entity.Department;

public interface DepartmentRepository extends ListCrudRepository<Department, Long> {

}
