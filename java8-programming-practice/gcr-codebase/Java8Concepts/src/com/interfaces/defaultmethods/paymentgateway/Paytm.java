package com.interfaces.defaultmethods.paymentgateway;

public class Paytm implements PaymentProcessor {

    private String userName;

    public Paytm(String userName) {
        this.userName = userName;
    }

    public void processPayment(double amount) {
        System.out.println("₹" + amount + " paid by " + userName + " via Paytm.");
    }
}

