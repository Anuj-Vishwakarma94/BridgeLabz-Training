package com.ewalletapplication;
import java.time.LocalDateTime;

public class Transaction {

    private String details;
    private double amount;
    private LocalDateTime time;

    public Transaction(String details, double amount) {
        this.details = details;
        this.amount = amount;
        this.time = LocalDateTime.now();
    }

    public void printTransaction() {
        System.out.println(time + " | " + details + " | ₹" + amount);
    }
}
