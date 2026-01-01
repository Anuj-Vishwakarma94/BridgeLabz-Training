package com.inheritance.hierarchical.vehicleandtransportsystem;

public class VehicleAndTransportSystem {

    public static void main(String[] args) {

        // Polymorphism: Vehicle array holding different subclass objects
        Vehicle[] vehicles = new Vehicle[3];

        vehicles[0] = new Car(180, "Petrol", 5);
        vehicles[1] = new Truck(120, "Diesel", 12.5);
        vehicles[2] = new Motorcycle(140, "Petrol", true);

        // Loop to demonstrate dynamic method dispatch
        for (Vehicle vehicle : vehicles) {
            System.out.println("--------------------");
            vehicle.displayInfo();
        }
    }
}
