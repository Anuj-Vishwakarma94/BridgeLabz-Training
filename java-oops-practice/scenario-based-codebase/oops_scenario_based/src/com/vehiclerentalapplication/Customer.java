package com.vehiclerentalapplication;
public class Customer {

    private String customerId;
    private String name;

    public Customer(String id, String name) {
        this.customerId = id;
        this.name = name;
    }

    public void displayInfo() {
        System.out.println("Customer => ID: " + customerId +
                ", Name: " + name);
    }
}
