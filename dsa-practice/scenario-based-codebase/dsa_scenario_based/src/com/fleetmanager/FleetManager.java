package com.fleetmanager;

import java.util.Scanner;

public class FleetManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of depots: ");
        int depots = sc.nextInt();

        System.out.print("Vehicles per depot: ");
        int perDepot = sc.nextInt();
        sc.nextLine();

        Vehicle[] masterList = new Vehicle[depots * perDepot];
        int index = 0;

        for (int d = 1; d <= depots; d++) {
            System.out.println("\nDepot " + d);
            for (int i = 0; i < perDepot; i++) {
                System.out.print("Vehicle ID: ");
                String id = sc.nextLine();

                System.out.print("Mileage: ");
                int mileage = sc.nextInt();
                sc.nextLine();

                masterList[index++] = new Vehicle(id, mileage);
            }
        }

        MergeSortUtil.mergeSort(masterList, 0, masterList.length - 1);

        System.out.println("\nMaster Maintenance Schedule:");
        for (int i = 0; i < masterList.length; i++) {
            System.out.println((i + 1) + ". " + masterList[i]);
        }

        sc.close();
    }
}
