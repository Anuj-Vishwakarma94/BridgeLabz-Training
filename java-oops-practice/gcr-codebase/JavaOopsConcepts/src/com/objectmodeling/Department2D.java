package com.objectmodeling;

public class Department2D {
	String departmentname;

    Department2D(String departmentname) {
        this.departmentname = departmentname;
    }

    void showDepartment() {
        System.out.println("Department: " + departmentname);
    }
}