package com.constructors.level1;

public class Manager extends Employee{
	private String teamName;
    public Manager(int employeeID, String department, double salary, String teamName) {
        super(employeeID, department, salary);
        this.teamName = teamName;
    }

    public void displayManagerDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + getSalary());
        System.out.println("Team Name: " + teamName);
    }

    public static void main(String[] args) {
        Manager m = new Manager(101, "IT", 75000, "Backend Team");
        m.displayManagerDetails();
        m.setSalary(82000);
        System.out.println();
        m.displayManagerDetails();
    }
}