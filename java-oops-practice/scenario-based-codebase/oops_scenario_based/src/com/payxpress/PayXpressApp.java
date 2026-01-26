package com.payxpress;

import java.util.*;

public class PayXpressApp {

    static ArrayList<IPayable> bills = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n--- PayXpress Utility Bill System ---");
            System.out.println("1. Add Bill");
            System.out.println("2. Show Reminders");
            System.out.println("3. Pay Bill");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: addBill(); break;
                case 2: showReminders(); break;
                case 3: payBill(); break;
                case 4: System.exit(0);
            }
        }
    }

    static void addBill() {

        System.out.println("Select Bill Type:");
        System.out.println("1. Electricity");
        System.out.println("2. Water");
        System.out.println("3. Internet");

        int type = sc.nextInt();

        System.out.println("Enter Amount:");
        double amount = sc.nextDouble();

        System.out.println("Enter Due Date:");
        String date = sc.next();

        IPayable bill = null;

        if (type == 1) bill = new ElectricityBill(amount, date);
        else if (type == 2) bill = new WaterBill(amount, date);
        else if (type == 3) bill = new InternetBill(amount, date);

        if (bill != null) {
            bills.add(bill);
            System.out.println("Bill Added Successfully");
        }
    }

    static void showReminders() {
        for (IPayable b : bills) {
            b.sendReminder();
        }
    }

    static void payBill() {

        if (bills.isEmpty()) {
            System.out.println("No bills available");
            return;
        }

        System.out.println("Enter Bill Number:");
        for (int i = 0; i < bills.size(); i++) {
            System.out.println((i + 1) + ". " + ((Bill) bills.get(i)).getType());
        }

        int index = sc.nextInt() - 1;

        if (index < 0 || index >= bills.size()) {
            System.out.println("Invalid choice");
            return;
        }

        System.out.println("Enter days late:");
        int daysLate = sc.nextInt();

        bills.get(index).pay(daysLate);
    }
}
