package com.cabbygo;
public class Sedan extends Vehicle {

    public Sedan(String number) {
        super(number, 4, "Sedan", 15); // ₹15 per km
    }

    @Override
    public void showVehicleInfo() {
        System.out.println("Sedan Cab | No: " + vehicleNumber + " | Capacity: " + capacity);
    }
}
