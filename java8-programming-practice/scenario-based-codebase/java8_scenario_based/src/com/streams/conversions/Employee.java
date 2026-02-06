package com.streams.conversions;

public class Employee {
    int id;
    String name;
    String dept;
    double salary;

    Employee(int id, String name, String dept, double salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    int getId() { return id; }
    String getName() { return name; }
    String getDept() { return dept; }
    double getSalary() { return salary; }

    public String toString() {
        return id + " " + name + " " + dept + " " + salary;
    }
}
