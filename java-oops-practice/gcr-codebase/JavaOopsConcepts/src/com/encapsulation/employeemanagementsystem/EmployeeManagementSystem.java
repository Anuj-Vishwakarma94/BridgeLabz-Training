package com.encapsulation.employeemanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManagementSystem {
	public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        Employee e1 = new FullTimeEmployee(101, "Akshat", 50000);
        Employee e2 = new PartTimeEmployee(102, "Rahul", 80, 300);

        ((Department) e1).assignDepartment("IT");
        ((Department) e2).assignDepartment("HR");

        employees.add(e1);
        employees.add(e2);

        // Polymorphism
        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println("Department: " +
                    ((Department) emp).getDepartmentDetails());
            System.out.println("-----------------------");
        }
    }
}
