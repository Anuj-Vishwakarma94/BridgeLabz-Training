package com.robowarehouse;

import java.util.Scanner;

public class RoboWarehouse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== RoboWarehouse System ===");

        System.out.print("Enter shelf capacity: ");
        int capacity = sc.nextInt();
        sc.nextLine();

        Shelf shelf = new Shelf(capacity);

        while (!shelf.isFull()) {

            System.out.println("\nAdd Package");
            System.out.println("Enter 'done' to stop manually");

            System.out.print("Package ID: ");
            String id = sc.nextLine().trim();

            if (id.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Package Weight (kg): ");
            double weight;

            try {
                weight = Double.parseDouble(sc.nextLine());
                if (weight <= 0) {
                    System.out.println("Weight must be positive.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid weight.");
                continue;
            }

            Package pkg = new Package(id, weight);

            if (shelf.addPackage(pkg)) {
                shelf.displayShelf();
            }
        }

        if (shelf.isFull()) {
            System.out.println("\nShelf capacity reached. No more packages can be added.");
        }

        System.out.println("\n=== Final Warehouse Status ===");
        System.out.println("Packages loaded: " + shelf.getSize() + " / " + shelf.getCapacity());
        shelf.displayShelf();

        System.out.println("\nRoboWarehouse shut down successfully.");
        sc.close();
    }
}
