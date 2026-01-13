package com.trafficmanager;

import java.util.Scanner;

public class TrafficManager {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Roundabout traffic = new Roundabout();

        while (true) {
            System.out.println("===== Smart Roundabout Traffic Manager =====");
            System.out.println("1. Vehicle Arrives");
            System.out.println("2. Allow Vehicle to Enter Roundabout");
            System.out.println("3. Vehicle Exit");
            System.out.println("4. Print Traffic State");
            System.out.println("5. Exit System");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter vehicle number: ");
                    traffic.arrive(sc.nextLine());
                    break;

                case 2:
                    traffic.tryEnter();
                    break;

                case 3:
                    System.out.print("Enter vehicle number to exit: ");
                    traffic.exit(sc.nextLine());
                    break;

                case 4:
                    traffic.printState();
                    break;

                case 5:
                    System.out.println("System closed");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
