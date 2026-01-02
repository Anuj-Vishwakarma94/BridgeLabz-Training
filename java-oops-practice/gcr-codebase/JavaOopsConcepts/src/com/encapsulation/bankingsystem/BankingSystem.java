package com.encapsulation.bankingsystem;

import java.util.ArrayList;
import java.util.List;

public class BankingSystem {
    public static void main(String[] args) {

        List<BankAccount> accounts = new ArrayList<>();

        BankAccount acc1 = new SavingsAccount("SB101", "Akshat", 50000);
        BankAccount acc2 = new CurrentAccount("CA202", "Rohit", 100000);

        accounts.add(acc1);
        accounts.add(acc2);

        for (BankAccount account : accounts) {

            account.displayAccountDetails();

            double interest = account.calculateInterest();
            System.out.println("Calculated Interest: " + interest);

            if (account instanceof Loanable) {
                Loanable loanAccount = (Loanable) account;
                loanAccount.applyForLoan(200000);
                System.out.println("Loan Eligibility: " +
                        loanAccount.calculateLoanEligibility());
            }

            System.out.println("-------------------------");
        }
    }
}
