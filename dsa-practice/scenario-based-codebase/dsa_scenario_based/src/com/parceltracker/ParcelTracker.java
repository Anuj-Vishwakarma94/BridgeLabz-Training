package com.parceltracker;

import java.util.Scanner;

public class ParcelTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ParcelChain chain = new ParcelChain();

        chain.addStage("Packed");
        chain.addStage("Shipped");
        chain.addStage("In Transit");
        chain.addStage("Delivered");

        while (true) {
            System.out.println("\n1. Track Parcel");
            System.out.println("2. Add Custom Checkpoint");
            System.out.println("3. Simulate Lost Parcel");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    chain.trackParcel();
                    break;

                case 2:
                    System.out.print("Add after stage: ");
                    String after = sc.next();
                    System.out.print("New stage name: ");
                    String newStage = sc.next();
                    chain.addAfter(after, newStage);
                    break;

                case 3:
                    chain.simulateLoss();
                    break;

                case 4:
                    System.out.println("Parcel tracking closed");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
