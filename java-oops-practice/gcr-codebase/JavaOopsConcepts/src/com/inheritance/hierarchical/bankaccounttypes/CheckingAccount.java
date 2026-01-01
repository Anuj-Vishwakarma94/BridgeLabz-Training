package com.inheritance.hierarchical.bankaccounttypes;

public class CheckingAccount extends BankAccount {

    private double withdrawalLimit;

    // Constructor to initialize checking account details
    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    // Overridden method to specify account type
    @Override
    public void displayAccountType() {
        System.out.println("Account Type      : Checking Account");
        System.out.println("Withdrawal Limit : " + withdrawalLimit);
    }
}
