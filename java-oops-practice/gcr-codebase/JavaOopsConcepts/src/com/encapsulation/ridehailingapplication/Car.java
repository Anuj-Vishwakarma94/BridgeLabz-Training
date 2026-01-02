package com.encapsulation.ridehailingapplication;

public class Car extends Vehicle implements GPS{

    private String location;

    public Car(String vehicleId, String driverName) {
        super(vehicleId, driverName, 15); // ₹15 per km
    }

    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm + 50; // base charge
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}
