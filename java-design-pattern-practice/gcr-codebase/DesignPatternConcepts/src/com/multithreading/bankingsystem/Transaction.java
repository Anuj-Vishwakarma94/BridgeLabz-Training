package com.multithreading.bankingsystem;
import java.time.LocalTime;

class Transaction implements Runnable {
    private BankAccount account;
    private int amount;
    private String customerName;

    Transaction(BankAccount account, int amount, String customerName) {
        this.account = account;
        this.amount = amount;
        this.customerName = customerName;
    }

    public void run() {
        System.out.println("[" + Thread.currentThread().getName() + "] State before execution: " + Thread.currentThread().getState());
        System.out.println("[" + Thread.currentThread().getName() + "] Attempting to withdraw " + amount);

        boolean success = account.withdraw(amount);

        if (success) {
            System.out.println("Transaction successful: " + customerName +
                    ", Amount: " + amount +
                    ", Balance: " + account.getBalance() +
                    ", Time: " + LocalTime.now());
        } else {
            System.out.println("Transaction failed: " + customerName +
                    ", Amount: " + amount +
                    ", Balance: " + account.getBalance() +
                    ", Time: " + LocalTime.now());
        }
    }
}
