package com.encapsulation.bankingsystem;

public class SavingsAccount extends BankAccount implements Loanable{
    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * 0.04; // 4% interest
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Loan applied for amount: " + amount);
    }

    @Override
    public double calculateLoanEligibility() {
        return balance * 5;
    }
}
