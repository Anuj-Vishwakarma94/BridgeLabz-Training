package com.cabbygo;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("🚖 Welcome to CabbyGo Ride Booking!");

        System.out.println("\nSelect Vehicle Type:");
        System.out.println("1. Mini");
        System.out.println("2. Sedan");
        System.out.println("3. SUV");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        Vehicle vehicle;

        switch (choice) {
            case 1: vehicle = new Mini("MP04AB1234"); break;
            case 2: vehicle = new Sedan("MP04XY5678"); break;
            case 3: vehicle = new SUV("MP04PQ9999"); break;
            default:
                System.out.println("Invalid choice. Defaulting to Mini.");
                vehicle = new Mini("MH00AA0000");
        }

        sc.nextLine(); // consume newline
        
        System.out.print("\nEnter Driver Name: ");
        String name = sc.nextLine();

        System.out.print("Enter License Number: ");
        String license = sc.nextLine();

        System.out.print("Enter Driver Rating (0-5): ");
        double rating = sc.nextDouble();

        Driver driver = new Driver(name, license, rating);

        System.out.print("\nEnter Ride Distance (km): ");
        double distance = sc.nextDouble();

        RideService ride = new RideService(vehicle, driver);

        ride.bookRide(distance);

        System.out.print("\nEnd Ride? (yes/no): ");
        sc.nextLine(); // consume newline
        String end = sc.nextLine();

        if (end.equalsIgnoreCase("yes")) {
            ride.endRide();
        } else {
            System.out.println("Ride still active!");
        }

        sc.close();
    }
}
