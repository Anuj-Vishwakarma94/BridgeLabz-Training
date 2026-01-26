package com.cabbygo;
public class Mini extends Vehicle {

    public Mini(String number) {
        super(number, 4, "Mini", 10); // ₹10 per km
    }

    @Override
    public void showVehicleInfo() {
        System.out.println("Mini Cab | No: " + vehicleNumber + " | Capacity: " + capacity);
    }
}
