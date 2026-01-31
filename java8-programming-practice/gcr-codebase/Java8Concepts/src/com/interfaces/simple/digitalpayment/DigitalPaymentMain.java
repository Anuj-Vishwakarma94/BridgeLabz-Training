package com.interfaces.simple.digitalpayment;

public class DigitalPaymentMain {

	public static void main(String[] args) {
		
		DigitalPayment p1 = new UPI();
		DigitalPayment p2 = new CreditCard();
		DigitalPayment p3 = new Wallet();
		
		p1.pay();
		p2.pay();
		p3.pay();
		
	}
}
