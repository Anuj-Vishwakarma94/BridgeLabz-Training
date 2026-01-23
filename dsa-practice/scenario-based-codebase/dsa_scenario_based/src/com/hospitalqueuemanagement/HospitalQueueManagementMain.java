package com.hospitalqueuemanagement;

import java.util.Scanner;

public class HospitalQueueManagementMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HospitalQueue hospital = new HospitalQueue();
        int choice;

        do {
            System.out.println("\n--- Hospital Queue Management ---");
            System.out.println("1. Register Patient");
            System.out.println("2. Discharge Patient");
            System.out.println("3. Display Patient Queue");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter check-in time: ");
                    int time = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter patient name: ");
                    String name = sc.nextLine();

                    hospital.root = hospital.registerPatient(hospital.root, time, name);
                    System.out.println("Patient Registered");
                    break;

                case 2:
                    System.out.print("Enter check-in time to discharge: ");
                    int dischargeTime = sc.nextInt();

                    hospital.root = hospital.dischargePatient(hospital.root, dischargeTime);
                    System.out.println("Discharge Operation Done");
                    break;

                case 3:
                    System.out.println("Patient Queue (Sorted by Check-In Time):");
                    hospital.displayQueue(hospital.root);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 4);

        sc.close();
    }
}
