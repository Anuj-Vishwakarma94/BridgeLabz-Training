package com.vehiclerentalapplication;
public class Truck extends Vehicle {

    private double loadCapacity; // in tons

    public Truck(String id, String brand, double rate, double loadCapacity) {
        super(id, brand, rate);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public double calculateRent(int days) {

        double rent = baseRate * days;

        // Heavy-load surcharge
        if (loadCapacity > 5) {
            rent += rent * 0.15;
        }

        return rent;
    }

    @Override
    public void displayInfo() {
        System.out.println("Truck => ID: " + vehicleId +
                ", Brand: " + brand +
                ", Rate/Day: ₹" + baseRate +
                ", Load Capacity: " + loadCapacity + " tons");
    }
}
