package com.vehiclerentalapplication;
public class Car extends Vehicle {

    private boolean luxury;

    public Car(String id, String brand, double rate, boolean luxury) {
        super(id, brand, rate);
        this.luxury = luxury;
    }

    @Override
    public double calculateRent(int days) {

        double rent = baseRate * days;

        // Luxury surcharge 12%
        if (luxury) {
            rent += rent * 0.12;
        }

        // Long-term discount 8% for 7+ days
        if (days >= 7) {
            rent -= rent * 0.08;
        }

        return rent;
    }

    @Override
    public void displayInfo() {
        System.out.println("Car => ID: " + vehicleId +
                ", Brand: " + brand +
                ", Rate/Day: ₹" + baseRate +
                ", Luxury: " + (luxury ? "Yes" : "No"));
    }
}