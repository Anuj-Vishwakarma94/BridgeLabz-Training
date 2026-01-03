package com.mybank;
public abstract class Account implements ITransaction {

    private String accountNumber;
    private double balance;   // encapsulated

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public Account(String accountNumber, double openingBalance) {
        this.accountNumber = accountNumber;
        this.balance = openingBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    // Secure access only
    public double checkBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0)
            balance += amount;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    // Protected — subclasses may use internally
    protected double getBalanceInternal() {
        return balance;
    }

    // Polymorphic method — different per account
    public abstract double calculateInterest();

    public void displayDetails() {
        System.out.println("Account No: " + accountNumber +
                " | Balance: ₹" + balance);
    }
}
