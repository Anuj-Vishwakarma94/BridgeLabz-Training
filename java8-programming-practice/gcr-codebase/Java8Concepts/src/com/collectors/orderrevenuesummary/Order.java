package com.collectors.orderrevenuesummary;

public class Order {
    private String customer;
    private double amount;

    Order(String customer, double amount) {
        this.customer = customer;
        this.amount = amount;
    }

    public String getCustomer() {
        return customer;
    }

    public double getAmount() {
        return amount;
    }
}