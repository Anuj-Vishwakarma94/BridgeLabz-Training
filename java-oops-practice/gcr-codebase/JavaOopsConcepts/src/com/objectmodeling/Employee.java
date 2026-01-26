package com.objectmodeling;

public class Employee {
	String employeename;

    Employee(String employeename) {
        this.employeename = employeename;
    }

    void showEmployee() {
        System.out.println("Employee: " + employeename);
    }
}

