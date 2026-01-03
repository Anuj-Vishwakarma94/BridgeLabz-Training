package com.vehiclerentalapplication;
public class Bike extends Vehicle {

    private boolean helmetIncluded;

    public Bike(String id, String brand, double rate, boolean helmetIncluded) {
        super(id, brand, rate);
        this.helmetIncluded = helmetIncluded;
    }

    @Override
    public double calculateRent(int days) {

        double rent = baseRate * days;

        // Discount — 5% off for 5+ days
        if (days >= 5) {
            rent -= rent * 0.05;
        }

        return rent;
    }

    @Override
    public void displayInfo() {
        System.out.println("Bike => ID: " + vehicleId +
                ", Brand: " + brand +
                ", Rate/Day: ₹" + baseRate +
                ", Helmet Included: " + (helmetIncluded ? "Yes" : "No"));
    }
}