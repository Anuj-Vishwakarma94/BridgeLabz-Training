package com.inheritance.hierarchical.schoolsystem;

public class SchoolSystemWithDifferentRoles {

    public static void main(String[] args) {

        // Hierarchical inheritance demonstration
        Person p1 = new Teacher("Mr. Sharma", 40, "Mathematics");
        Person p2 = new Student("Ram", 15, "10th Grade");
        Person p3 = new Staff("Anil", 35, "Administration");

        p1.displayDetails();
        p1.displayRole();
        System.out.println("---------------------");

        p2.displayDetails();
        p2.displayRole();
        System.out.println("---------------------");

        p3.displayDetails();
        p3.displayRole();
    }
}
