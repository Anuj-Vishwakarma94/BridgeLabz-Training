package com.encapsulation.ridehailingapplication;

public class Bike extends Vehicle implements GPS{
    private String location;

    public Bike(String vehicleId, String driverName) {
        super(vehicleId, driverName, 8); // ₹8 per km
    }

    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm; // no base charge
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
