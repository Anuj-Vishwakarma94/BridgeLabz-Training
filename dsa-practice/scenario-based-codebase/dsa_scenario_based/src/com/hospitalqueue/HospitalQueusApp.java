package com.hospitalqueue;

import java.util.Scanner;

public class HospitalQueusApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of patients: ");
        int n = sc.nextInt();
        sc.nextLine();

        Patient[] patients = new Patient[n];

        for (int i = 0; i < n; i++) {

            System.out.print("Patient name: ");
            String name = sc.nextLine();

            int criticality;
            while (true) {
                System.out.print("Criticality (1-10): ");
                criticality = sc.nextInt();

                if (criticality >= 1 && criticality <= 10) {
                    break;
                } else {
                    System.out.println("Invalid input! Enter value between 1 and 10.");
                }
            }
            sc.nextLine();

            patients[i] = new Patient(name, criticality);
        }

        System.out.println("\nBefore Sorting:");
        HospitalQueue.display(patients, n);

        HospitalQueue.sortByCriticality(patients, n);

        System.out.println("\nAfter Sorting (High to Low Criticality):");
        HospitalQueue.display(patients, n);

        sc.close();
    }
}
