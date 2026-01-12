package com.traincompanion;

import java.util.*;

public class TrainCompanion {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TrainRoute route = new TrainRoute();

        while (true) {

            System.out.println("\n1. Add Compartment");
            System.out.println("2. Remove Compartment");
            System.out.println("3. Traverse Forward");
            System.out.println("4. Traverse Backward");
            System.out.println("5. Show Adjacent Compartments");
            System.out.println("6. Search Service");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter compartment name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter services (comma separated): ");
                    String[] services = sc.nextLine().split(",");

                    route.addCompartment(name, Arrays.asList(services));
                    break;

                case 2:
                    System.out.print("Enter compartment name to remove: ");
                    route.removeCompartment(sc.nextLine());
                    break;

                case 3:
                    route.traverseForward();
                    break;

                case 4:
                    route.traverseBackward();
                    break;

                case 5:
                    System.out.print("Enter compartment name: ");
                    route.showAdjacent(sc.nextLine());
                    break;

                case 6:
                    System.out.print("Enter service name: ");
                    route.searchService(sc.nextLine());
                    break;

                case 7:
                    System.exit(0);
            }
        }
    }
}
