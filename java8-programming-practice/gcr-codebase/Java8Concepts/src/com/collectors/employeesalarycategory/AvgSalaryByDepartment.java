package com.collectors.employeesalarycategory;

import java.util.*;
import java.util.stream.Collectors;

public class AvgSalaryByDepartment {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("IT", 60000),
                new Employee("HR", 40000),
                new Employee("IT", 80000),
                new Employee("HR", 50000)
        );

        Map<String, Double> avgSalaryByDept =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.averagingDouble(Employee::getSalary)
                        ));

        System.out.println(avgSalaryByDept);
    }
}
