package com.mybank;
public interface ITransaction {
    void deposit(double amount);
    boolean withdraw(double amount);
    double checkBalance();
}
