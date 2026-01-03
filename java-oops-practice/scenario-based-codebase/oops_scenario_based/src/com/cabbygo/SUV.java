package com.cabbygo;
public class SUV extends Vehicle {

    public SUV(String number) {
        super(number, 6, "SUV", 20); // ₹20 per km
    }

    @Override
    public void showVehicleInfo() {
        System.out.println("SUV Cab | No: " + vehicleNumber + " | Capacity: " + capacity);
    }
}
