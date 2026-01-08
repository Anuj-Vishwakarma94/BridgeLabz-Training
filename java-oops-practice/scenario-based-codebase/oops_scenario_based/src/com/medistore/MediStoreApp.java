package com.medistore;

import java.time.LocalDate;
import java.util.Scanner;

public class MediStoreApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Medicine medicine = null;

        Medicine tab1 = new Tablet("Paracetamol", 5.0,
                LocalDate.of(2026, 3, 10));
        Medicine tab2 = new Tablet("Azithromycin", 12.0,
                LocalDate.of(2025, 12, 1));

        Medicine syr1 = new Syrup("Cough Syrup", 120.0,
                LocalDate.of(2025, 8, 1));
        Medicine syr2 = new Syrup("Vitamin Syrup", 150.0,
                LocalDate.of(2026, 6, 15));

        Medicine inj1 = new Injection("Insulin", 300.0,
                LocalDate.of(2025, 6, 20));
        Medicine inj2 = new Injection("Tetanus", 90.0,
                LocalDate.of(2026, 11, 5));

        System.out.println("=== MediStore Pharmacy System ===");
        System.out.println("1. Tablet");
        System.out.println("2. Syrup");
        System.out.println("3. Injection");
        System.out.print("Choose category: ");
        int category = sc.nextInt();

        System.out.println("\nAvailable Medicines:");

        switch (category) {
            case 1:
                System.out.println("1. Paracetamol");
                System.out.println("2. Azithromycin");
                int t = sc.nextInt();
                medicine = (t == 1) ? tab1 : tab2;
                break;

            case 2:
                System.out.println("1. Cough Syrup");
                System.out.println("2. Vitamin Syrup");
                int s = sc.nextInt();
                medicine = (s == 1) ? syr1 : syr2;
                break;

            case 3:
                System.out.println("1. Insulin");
                System.out.println("2. Tetanus");
                int i = sc.nextInt();
                medicine = (i == 1) ? inj1 : inj2;
                break;

            default:
                System.out.println("Invalid category");
                System.exit(0);
        }

        System.out.print("Enter quantity to sell: ");
        int units = sc.nextInt();

        try {
            double bill = medicine.sell(units);
            System.out.println("\n Sale Successful");
            System.out.println("Medicine: " + medicine.getName());
            System.out.println("Total Bill: ₹" + bill);
            System.out.println("Remaining Stock: " + medicine.getQuantity());
        } catch (Exception e) {
            System.out.println("\n Sale Failed: " + e.getMessage());
        }

        sc.close();
    }
}
