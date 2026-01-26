package com.cabbygo;
public abstract class Vehicle {

    protected String vehicleNumber;
    protected int capacity;
    protected String type;
    protected double ratePerKm;

    public Vehicle(String vehicleNumber, int capacity, String type, double ratePerKm) {
        this.vehicleNumber = vehicleNumber;
        this.capacity = capacity;
        this.type = type;
        this.ratePerKm = ratePerKm;
    }

    public String getVehicleNumber() { return vehicleNumber; }
    public int getCapacity() { return capacity; }
    public String getType() { return type; }

    public abstract void showVehicleInfo();
}
