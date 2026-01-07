package com.parkease;
class Truck extends Vehicle {

    public Truck(String vehicleNo){
        super(vehicleNo);
    }

    @Override
    public double calculateCharges(int hours){
        double baseRate = 100;
        return (baseRate * hours);
    }
}