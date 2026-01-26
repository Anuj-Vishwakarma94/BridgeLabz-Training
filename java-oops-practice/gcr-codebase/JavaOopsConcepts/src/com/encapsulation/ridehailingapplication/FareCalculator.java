package com.encapsulation.ridehailingapplication;

import java.util.List;

public class FareCalculator {
	 public static void calculateFareForRides(List<Vehicle> vehicles, double distance) {

	        for (Vehicle vehicle : vehicles) {

	            vehicle.getVehicleDetails();
	            double fare = vehicle.calculateFare(distance);
	            System.out.println("Distance: " + distance + " km");
	            System.out.println("Total Fare: ₹" + fare);

	            if (vehicle instanceof GPS) {
	                System.out.println("Current Location: " +
	                        ((GPS) vehicle).getCurrentLocation());
	            }

	            System.out.println("---------------------------");
	        }
	    }
}
