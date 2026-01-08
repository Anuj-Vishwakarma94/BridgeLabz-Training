package com.tourmate;

import java.util.Scanner;

public class TourMateApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to TourMate ");
        System.out.println("1. Domestic Trip");
        System.out.println("2. International Trip");
        System.out.print("Choose trip type: ");
        int type = sc.nextInt();

        Trip trip = null;

        if (type == 1) {
            System.out.println("\nSelect Domestic Destination:");
            System.out.println("1. Goa (3 Days)");
            System.out.println("2. Manali (4 Days)");
            System.out.println("3. Jaipur (2 Days)");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                trip = new DomesticTrip(
                        "Goa", 3,
                        new Transport(5000),
                        new Hotel(2000, 2),
                        new Activity(1500)
                );
            } else if (choice == 2) {
                trip = new DomesticTrip(
                        "Manali", 4,
                        new Transport(6000),
                        new Hotel(1800, 3),
                        new Activity(2000)
                );
            } else if (choice == 3) {
                trip = new DomesticTrip(
                        "Jaipur", 2,
                        new Transport(3000),
                        new Hotel(1500, 1),
                        new Activity(1000)
                );
            }

        } else if (type == 2) {
            // International options
            System.out.println("\nSelect International Destination:");
            System.out.println("1. Paris (5 Days)");
            System.out.println("2. Dubai (4 Days)");
            System.out.println("3. Singapore (3 Days)");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                trip = new InternationalTrip(
                        "Paris", 5,
                        new Transport(45000),
                        new Hotel(8000, 4),
                        new Activity(12000)
                );
            } else if (choice == 2) {
                trip = new InternationalTrip(
                        "Dubai", 4,
                        new Transport(30000),
                        new Hotel(7000, 3),
                        new Activity(9000)
                );
            } else if (choice == 3) {
                trip = new InternationalTrip(
                        "Singapore", 3,
                        new Transport(35000),
                        new Hotel(7500, 2),
                        new Activity(10000)
                );
            }
        }

        if (trip != null) {
            trip.book();  
        } else {
            System.out.println("Invalid choice!");
        }

        sc.close();
    }
}
