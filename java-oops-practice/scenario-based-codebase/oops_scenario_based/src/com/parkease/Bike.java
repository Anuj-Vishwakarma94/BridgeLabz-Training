package com.parkease;
class Bike extends Vehicle {

    public Bike(String vehicleNo){
        super(vehicleNo);
    }

    @Override
    public double calculateCharges(int hours){
        double baseRate = 20;
        return (baseRate * hours);
    }
}