package com.inheritance.hierarchical.vehicleandtransportsystem;

public class Motorcycle extends Vehicle {

    private boolean hasCarrier;

    // Constructor to initialize motorcycle details
    public Motorcycle(int maxSpeed, String fuelType, boolean hasCarrier) {
        super(maxSpeed, fuelType);
        this.hasCarrier = hasCarrier;
    }

    // Overridden method with motorcycle-specific details
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Carrier Available : " + hasCarrier);
    }
}
