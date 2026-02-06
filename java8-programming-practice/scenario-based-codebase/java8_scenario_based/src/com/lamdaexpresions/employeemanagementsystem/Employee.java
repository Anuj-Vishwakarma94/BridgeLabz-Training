package com.lamdaexpresions.employeemanagementsystem;

public class Employee {
    int id;
    String name;
    double salary;
    int experience;

    public Employee(int id, String name, double salary, int experience) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.experience = experience;
    }

    public String toString() {
        return id + " " + name + " " + salary + " " + experience;
    }
}
