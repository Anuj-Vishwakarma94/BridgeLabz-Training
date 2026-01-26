package com.objectmodeling;

public class Customer {
	String customername;
    double balance;

    Customer(String customername, double balance) {
        this.customername = customername;
        this.balance = balance;
    }

    void viewBalance() {
        System.out.println(customername + "'s balance: " + balance);
    }
}
