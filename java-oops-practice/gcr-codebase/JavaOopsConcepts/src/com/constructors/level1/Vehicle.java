package com.constructors.level1;

public class Vehicle {
	String ownerName;
    String vehicleType;

    static double registrationFee = 5000;

    Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }
    
    void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: Rs. " + registrationFee);
    }

    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public static void main(String[] args) {

        Vehicle v1 = new Vehicle("Harry", "Car");
        Vehicle v2 = new Vehicle("Henry", "Bike");

        v1.displayVehicleDetails();
        System.out.println();
        v2.displayVehicleDetails();

        Vehicle.updateRegistrationFee(6500);

        System.out.println();
        v1.displayVehicleDetails();
        System.out.println();
        v2.displayVehicleDetails();
    }
}