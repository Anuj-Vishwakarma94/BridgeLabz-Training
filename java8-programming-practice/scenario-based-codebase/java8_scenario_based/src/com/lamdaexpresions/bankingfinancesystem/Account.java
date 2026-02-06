package com.lamdaexpresions.bankingfinancesystem;

public class Account {
    int accNo;
    String name;
    double balance;

    public Account(int accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }

    public String toString() {
        return accNo + " " + name + " " + balance;
    }
}
