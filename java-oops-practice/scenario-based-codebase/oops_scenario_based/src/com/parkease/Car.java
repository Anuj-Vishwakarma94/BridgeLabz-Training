package com.parkease;
class Car extends Vehicle {

    public Car(String vehicleNo){
        super(vehicleNo);
    }

    @Override
    public double calculateCharges(int hours){
        double baseRate = 50;
        return (baseRate * hours);
    }
}