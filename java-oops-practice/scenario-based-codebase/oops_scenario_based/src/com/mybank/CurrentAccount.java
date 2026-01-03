package com.mybank;
public class CurrentAccount extends Account {

    private double interestRate = 1.5;   // lower rate

    public CurrentAccount(String accNo) {
        super(accNo);
    }

    public CurrentAccount(String accNo, double openingBalance) {
        super(accNo, openingBalance);
    }

    @Override
    public double calculateInterest() {

        return getBalanceInternal() * interestRate / 100;
    }

    @Override
    public void displayDetails() {
        System.out.println("Current Account | " +
                "Acc No: " + getAccountNumber() +
                " | Balance: ₹" + checkBalance());
    }
}
