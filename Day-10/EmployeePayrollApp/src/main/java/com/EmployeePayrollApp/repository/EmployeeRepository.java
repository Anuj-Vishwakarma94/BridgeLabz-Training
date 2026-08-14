package com.EmployeePayrollApp.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.EmployeePayrollApp.entity.Employee;

public interface EmployeeRepository extends ListCrudRepository<Employee, Long> {

}
