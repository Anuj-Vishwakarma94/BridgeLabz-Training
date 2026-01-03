package com.mybank;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("🏦 Welcome to MyBank!");

        System.out.println("\nSelect account type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        sc.nextLine(); // consume newline

        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();

        System.out.print("Opening balance? (y/n): ");
        String op = sc.nextLine();

        Account account;

        if (op.equalsIgnoreCase("y")) {
            System.out.print("Enter opening balance: ");
            double bal = sc.nextDouble();

            account = (choice == 1)
                    ? new SavingsAccount(accNo, bal)
                    : new CurrentAccount(accNo, bal);

        } else {
            account = (choice == 1)
                    ? new SavingsAccount(accNo)
                    : new CurrentAccount(accNo);
        }

        System.out.println("\n--- ACCOUNT CREATED ---");
        account.displayDetails();

        // deposit
        System.out.print("\nEnter amount to deposit: ₹");
        double dep = sc.nextDouble();
        account.deposit(dep);

        // withdraw
        System.out.print("Enter amount to withdraw: ₹");
        double wd = sc.nextDouble();
        if (!account.withdraw(wd)) {
            System.out.println("❌ Withdrawal failed — insufficient funds.");
        }

        System.out.println("\n--- FINAL ACCOUNT STATUS ---");
        account.displayDetails();

        System.out.println("\nCalculated Interest: ₹" + account.calculateInterest());

        sc.close();
    }
}
