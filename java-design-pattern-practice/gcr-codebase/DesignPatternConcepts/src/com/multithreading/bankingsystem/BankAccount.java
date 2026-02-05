package com.multithreading.bankingsystem;
class BankAccount {
    private int balance = 10000;

    public int getBalance() {
        return balance;
    }

    public boolean withdraw(int amount) {
        if (balance >= amount) {
            balance = balance - amount;
            return true;
        }
        return false;
    }
}
