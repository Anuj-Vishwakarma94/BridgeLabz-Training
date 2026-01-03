package com.bank_management_system;
import java.util.*;
public class BankSystem {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);

        // Create Customer
        Customer c1 = new Customer("Rahul Verma", "CUS101");
        c1.displayCustomer();

        // Create Account
        SavingsAccount sa = new SavingsAccount("SAV123", 12000, 4.5);
        Validator.printAccountSummary(sa);

        LoanManager loanManager = new LoanManager();

        // Validate + Loan Check
        if (loanManager.checkLoanEligibility(sa)) {
            System.out.println("🎉 Customer is eligible for a loan.");

            double eligibleAmount = loanManager.calculateEligibleAmount(sa);
            System.out.println("Eligible Loan Amount: ₹" + eligibleAmount);

            double discount = loanManager.calculateDiscount(sa, eligibleAmount);
            System.out.println("Discount Applicable: ₹" + discount);

            System.out.println("Final Loan Processing Amount: ₹" + (eligibleAmount - discount));

        } else {
            System.out.println("❌ Customer is NOT eligible for a loan.");
        }

        sc.close();
    }
}