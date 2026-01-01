package com.inheritance.hierarchical.vehicleandtransportsystem;

public class Truck extends Vehicle {

    private double loadCapacity;

    // Constructor to initialize truck details
    public Truck(int maxSpeed, String fuelType, double loadCapacity) {
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }

    // Overridden method with truck-specific details
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Load Capacity : " + loadCapacity + " tons");
    }
}
