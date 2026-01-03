package com.ewalletapplication;
public abstract class Wallet implements Transferrable {

    private double balance;   // Encapsulated
    protected double dailyLimit;

    public Wallet(double initialAmount) {
        this.balance = initialAmount;
    }

    // Optional referral bonus constructor
    public Wallet(double initialAmount, double referralBonus) {
        this.balance = initialAmount + referralBonus;
    }

    public double getBalance() {
        return balance;
    }

    protected void deposit(double amount) {
        balance += amount;
    }

    protected boolean deduct(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public abstract boolean transferTo(User receiver, double amount);

    public abstract void displayWalletType();
}
