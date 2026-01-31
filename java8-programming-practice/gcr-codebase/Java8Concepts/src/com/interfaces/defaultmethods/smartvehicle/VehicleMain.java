package com.interfaces.defaultmethods.smartvehicle;

public class VehicleMain {
    public static void main(String[] args) {

        VehicleDashboard car = new ElectricCar("Tesla Model 3");

        car.displaySpeed(80);
        car.displayBatteryLevel(65);
    }
}

