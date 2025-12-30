package com.objectmodeling;

import java.util.ArrayList;
import java.util.Scanner;

public class Company {

    String companyname;
    ArrayList<Department> departmentlist = new ArrayList<>();

    Company(String companyname) {
        this.companyname = companyname;
    }

    void addDepartment(Department department) {
        departmentlist.add(department);
    }

    void showCompanyDetails() {
        System.out.println("Company: " + companyname);
        for (Department department : departmentlist) {
            department.showDepartmentDetails();
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Company company = new Company("Bridgelabz");

        Department itDept = new Department("IT");
        itDept.addEmployee("Aryan");
        itDept.addEmployee("Rahul");

        Department hrDept = new Department("HR");
        hrDept.addEmployee("Neha");

        company.addDepartment(itDept);
        company.addDepartment(hrDept);

        company.showCompanyDetails();

        // when company is removed, departments and employees also go
        company = null;
        System.out.println("Company deleted");
        sc.close();    
    }   
}
