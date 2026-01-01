package com.inheritance.hierarchical.employeemanagementsystem;

public class EmployeeManagementSystem {

    public static void main(String[] args) {

        // Polymorphism: parent reference holding different employee types
        Employee emp1 = new Manager("Ravi", 101, 75000, 8);
        Employee emp2 = new Developer("Anita", 102, 60000, "Java");
        Employee emp3 = new Intern("Kunal", 103, 15000, 6);

        emp1.displayDetails();
        System.out.println("---------------------");

        emp2.displayDetails();
        System.out.println("---------------------");

        emp3.displayDetails();
    }
}
