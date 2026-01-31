package com.interfaces.marker.sensetivedatatagging;

public class EncryptionMain {

    private static void process(Object obj) {

        if (obj instanceof Sensitive) {
            System.out.println("Encrypting sensitive data...");
        } else {
            System.out.println("Normal processing...");
        }
    }

    public static void main(String[] args) {

        BankAccount acc = new BankAccount("987654321");

        process(acc);
        System.out.println("Account: " + acc.getAccountNumber());
    }
}

