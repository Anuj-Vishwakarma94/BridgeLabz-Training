package com.EmployeePayrollApp.entity;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table("employee")
public class Employee {

    @Id
    private Long id;
    private String name;
    private String email;
    private String phone;
    private BigDecimal salary;
    private Long departmentId;
}
