package com.bankmanagementsystem;
class Customer {
    private String name;
    private String customerId;

    public Customer(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
    }

    public void displayCustomer() {
        System.out.println("Customer: " + name + " | ID: " + customerId);
    }
}