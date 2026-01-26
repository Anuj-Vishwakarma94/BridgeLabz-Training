package com.inheritance.hierarchical.bankaccounttypes;

public class BankAccountTypes {

    public static void main(String[] args) {

        // Hierarchical inheritance demonstration
        BankAccount acc1 = new SavingsAccount("SB1001", 50000, 4.5);
        BankAccount acc2 = new CheckingAccount("CA2001", 30000, 10000);
        BankAccount acc3 = new FixedDepositAccount("FD3001", 200000, 5);

        acc1.displayDetails();
        acc1.displayAccountType();
        System.out.println("----------------------");

        acc2.displayDetails();
        acc2.displayAccountType();
        System.out.println("----------------------");

        acc3.displayDetails();
        acc3.displayAccountType();
    }
}
