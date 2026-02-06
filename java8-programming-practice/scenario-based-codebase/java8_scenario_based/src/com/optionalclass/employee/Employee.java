package com.optionalclass.employee;

import java.util.Optional;

public class Employee {

    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private Double bonus;
    private Employee manager;
    private String insurance;

    public Employee(int id, String firstName, String middleName, String lastName,
                    String email, Double bonus, Employee manager, String insurance) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.bonus = bonus;
        this.manager = manager;
        this.insurance = insurance;
    }

    public Optional<Employee> getManager() {
        return Optional.ofNullable(manager);
    }

    public Optional<Double> getBonus() {
        return Optional.ofNullable(bonus);
    }

    public Optional<String> getInsurance() {
        return Optional.ofNullable(insurance);
    }

    public Optional<String> getMiddleName() {
        return Optional.ofNullable(middleName);
    }

    public String getEmail() {
        return email;
    }
}

