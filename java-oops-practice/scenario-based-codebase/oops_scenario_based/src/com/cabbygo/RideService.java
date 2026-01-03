package com.cabbygo;
public class RideService implements IRideService {

    private Vehicle vehicle;
    private Driver driver;

    private double distance;
    private double fare;     // encapsulated
    private boolean rideActive = false;

    private final double baseFare = 50; // flat base fare

    public RideService(Vehicle vehicle, Driver driver) {
        this.vehicle = vehicle;
        this.driver = driver;
    }

    @Override
    public void bookRide(double distanceKm) {

        if (rideActive) {
            System.out.println("A ride is already active!");
            return;
        }

        this.distance = distanceKm;

        // Operators used here
        fare = baseFare + (distance * vehicle.ratePerKm);

        rideActive = true;

        System.out.println("\n🚕 Ride Booked Successfully!");
        vehicle.showVehicleInfo();
        driver.showDriverInfo();
        System.out.println("Distance: " + distance + " km");
        System.out.println("Estimated Fare: ₹" + fare);
    }

    @Override
    public void endRide() {

        if (!rideActive) {
            System.out.println("No active ride to end.");
            return;
        }

        rideActive = false;

        System.out.println("\n✔ Ride Ended Successfully!");
        System.out.println("Total Fare: ₹" + fare);
        System.out.println("Thank you for riding with CabbyGo!");
    }

    public double getFare() { return fare; }
}
