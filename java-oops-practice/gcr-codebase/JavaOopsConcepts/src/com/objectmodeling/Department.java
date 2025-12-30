package com.objectmodeling;

import java.util.ArrayList;

public class Department {

    String departmentname;
    ArrayList<Employee> employeelist = new ArrayList<>();

    Department(String departmentname) {
        this.departmentname = departmentname;
    }

    void addEmployee(String employeename) {
        Employee employee = new Employee(employeename);
        employeelist.add(employee);
    }

    void showDepartmentDetails() {
        System.out.println("Department: " + departmentname);
        for (Employee employee : employeelist) {
            employee.showEmployee();
        }
    }
}
