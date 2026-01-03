package com.mybank;
public class SavingsAccount extends Account {

    private double interestRate = 4.5;   // default yearly %

    public SavingsAccount(String accNo) {
        super(accNo);
    }

    public SavingsAccount(String accNo, double openingBalance) {
        super(accNo, openingBalance);
    }

    @Override
    public double calculateInterest() {

        // Formula: P * R / 100
        return getBalanceInternal() * interestRate / 100;
    }

    @Override
    public void displayDetails() {
        System.out.println("Savings Account | " +
                "Acc No: " + getAccountNumber() +
                " | Balance: ₹" + checkBalance());
    }
}
