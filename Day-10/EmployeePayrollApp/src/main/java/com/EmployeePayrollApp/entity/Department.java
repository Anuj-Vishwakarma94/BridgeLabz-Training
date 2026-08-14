package com.EmployeePayrollApp.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table("department")
public class Department {

    @Id
    private Long id;
    private String name;
}
