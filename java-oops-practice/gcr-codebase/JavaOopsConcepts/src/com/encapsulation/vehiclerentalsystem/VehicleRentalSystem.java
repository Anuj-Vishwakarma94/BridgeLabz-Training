package com.encapsulation.vehiclerentalsystem;

import java.util.ArrayList;
import java.util.List;

public class VehicleRentalSystem {

    public static void main(String[] args) {

        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("DL01AB1234", 2000, "CAR123"));
        vehicles.add(new Bike("DL02XY5678", 800, "BIKE456"));
        vehicles.add(new Truck("DL03TR9999", 5000));

        int rentalDays = 5;

        for (Vehicle vehicle : vehicles) {

            vehicle.displayVehicleDetails();

            double rentalCost = vehicle.calculateRentalCost(rentalDays);
            double insuranceCost = 0;

            if (vehicle instanceof Insurable) {
                insuranceCost = ((Insurable) vehicle).calculateInsurance();
                System.out.println("Insurance: " +
                        ((Insurable) vehicle).getInsuranceDetails());
            } else {
                System.out.println("Insurance: Not Applicable");
            }

            System.out.println("Rental Cost (" + rentalDays + " days): " + rentalCost);
            System.out.println("Insurance Cost: " + insuranceCost);
            System.out.println("Total Cost: " + (rentalCost + insuranceCost));
            System.out.println("----------------------------");
        }
    }
}
