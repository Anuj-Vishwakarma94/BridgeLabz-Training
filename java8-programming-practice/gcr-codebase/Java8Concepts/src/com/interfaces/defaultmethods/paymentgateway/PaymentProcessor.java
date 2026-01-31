package com.interfaces.defaultmethods.paymentgateway;

public interface PaymentProcessor {

    public void processPayment(double amount);

    public default void refund(double amount) {
        System.out.println("Refunded ₹" + amount + " successfully.");
    }
}

