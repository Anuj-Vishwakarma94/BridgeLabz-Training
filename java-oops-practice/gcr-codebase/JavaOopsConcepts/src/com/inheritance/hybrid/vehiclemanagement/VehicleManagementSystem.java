package com.inheritance.hybrid.vehiclemanagement;

public class VehicleManagementSystem {

    public static void main(String[] args) {

        // Hybrid inheritance demonstration
        Vehicle ev = new ElectricVehicle("Rimac Nevera", 380, 75);
        Vehicle pv = new PetrolVehicle("Mustang Gt", 280, 40);

        ev.displayInfo();
        ((ElectricVehicle) ev).charge();
        System.out.println("---------------------");

        pv.displayInfo();
        ((PetrolVehicle) pv).refuel();
    }
}
