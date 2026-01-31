package com.interfaces.defaultmethods.paymentgateway;

public class PaymentMain {
    public static void main(String[] args) {

        PaymentProcessor payment = new Paytm("Anuj");

        payment.processPayment(500);
        payment.refund(200);
    }
}

