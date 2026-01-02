package com.encapsulation.vehiclerentalsystem;

public class Truck extends Vehicle{
    public Truck(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Truck", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return (rentalRate * days) + 1000; // heavy-duty charge
    }
}
