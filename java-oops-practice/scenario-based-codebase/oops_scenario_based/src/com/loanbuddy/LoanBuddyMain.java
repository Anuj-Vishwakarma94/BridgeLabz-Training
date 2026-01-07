package com.loanbuddy;

import java.util.Scanner;

public class LoanBuddyMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Applicant Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Credit Score: ");
        int creditScore = sc.nextInt();

        System.out.print("Enter Monthly Income: ");
        double income = sc.nextDouble();

        System.out.print("Enter Loan Amount: ");
        double loanAmount = sc.nextDouble();

        System.out.print("Enter Loan Term (in months): ");
        int term = sc.nextInt();

        if (term < 1) {
            System.out.println("Loan term must be at least 1 month.");
            return;
        }

        System.out.print("Enter Interest Rate (per year %): ");
        double rate = sc.nextDouble();

        System.out.println("\nChoose Loan Type:");
        System.out.println("1. Home Loan");
        System.out.println("2. Auto Loan");
        System.out.println("3. Personal Loan");
        int choice = sc.nextInt();

        Applicant applicant = new Applicant(name, creditScore, income, loanAmount);

        LoanApplication loan;

        switch (choice) {
            case 1:
                loan = new HomeLoan(applicant, rate, term);
                break;
            case 2:
                loan = new AutoLoan(applicant, rate, term);
                break;
            default:
                loan = new PersonalLoan(applicant, rate, term);
        }

        if (loan.approveLoan()) {
            System.out.println("\nLoan Approved ");
            System.out.println("Monthly EMI = " + String.format("%.2f", loan.calculateEMI()));
        } else {
            System.out.println("\nLoan Rejected ");
        }

        sc.close();
    }
}
