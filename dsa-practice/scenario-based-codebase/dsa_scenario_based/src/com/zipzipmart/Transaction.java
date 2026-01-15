package com.zipzipmart;
public class Transaction {
    String date;     // format: YYYY-MM-DD
    double amount;

    public Transaction(String date, double amount) {
        this.date = date;
        this.amount = amount;
    }
}
