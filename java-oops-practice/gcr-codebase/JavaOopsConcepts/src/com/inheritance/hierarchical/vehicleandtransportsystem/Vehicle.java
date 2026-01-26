package com.inheritance.hierarchical.vehicleandtransportsystem;

public class Vehicle {

    protected int maxSpeed;
    protected String fuelType;

    // Constructor to initialize vehicle details
    public Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    // Method to display vehicle information (to be overridden)
    public void displayInfo() {
        System.out.println("Max Speed : " + maxSpeed + " km/h");
        System.out.println("Fuel Type : " + fuelType);
    }
}
