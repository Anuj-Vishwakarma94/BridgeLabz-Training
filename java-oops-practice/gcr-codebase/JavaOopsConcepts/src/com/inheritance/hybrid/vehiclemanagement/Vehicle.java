package com.inheritance.hybrid.vehiclemanagement;

public class Vehicle {

    protected String model;
    protected int maxSpeed;

    // Constructor to initialize vehicle details
    public Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    // Method to display vehicle information
    public void displayInfo() {
        System.out.println("Model     : " + model);
        System.out.println("Max Speed : " + maxSpeed + " km/h");
    }
}
