package com.vehiclerentalapplication;
public abstract class Vehicle implements Rentable {

    protected String vehicleId;
    protected String brand;
    protected double baseRate; // rent per day

    public Vehicle(String vehicleId, String brand, double baseRate) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.baseRate = baseRate;
    }

    // Encapsulation — controlled access
    public String getVehicleId() { return vehicleId; }
    public String getBrand() { return brand; }
    public double getBaseRate() { return baseRate; }

    public void setBaseRate(double baseRate) {
        this.baseRate = baseRate;
    }

    public abstract void displayInfo();
}