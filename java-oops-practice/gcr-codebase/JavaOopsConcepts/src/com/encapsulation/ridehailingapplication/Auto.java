package com.encapsulation.ridehailingapplication;

public class Auto extends Vehicle implements GPS{
    private String location;

    public Auto(String vehicleId, String driverName) {
        super(vehicleId, driverName, 12); // ₹12 per km
    }

    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm + 20; // minimal base charge
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
