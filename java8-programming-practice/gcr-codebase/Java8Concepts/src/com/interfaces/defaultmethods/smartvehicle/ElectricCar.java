package com.interfaces.defaultmethods.smartvehicle;

public class ElectricCar implements VehicleDashboard {

    private String model;

    public ElectricCar(String model) {
        this.model = model;
    }

    public void displaySpeed(int speed) {
        System.out.println("Car Model: " + model);
        System.out.println("Speed: " + speed + " km/h");
    }
}

