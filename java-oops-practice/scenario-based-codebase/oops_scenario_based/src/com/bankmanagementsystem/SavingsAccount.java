package com.bankmanagementsystem;
class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accNo, double balance, double interestRate) {
        super(accNo, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("Savings Account | Acc No: " + getAccountNumber() +
                " | Balance: " + balance +
                " | Interest Rate: " + interestRate + "%");
    }
}
