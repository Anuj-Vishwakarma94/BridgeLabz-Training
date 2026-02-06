package com.lamdaexpresions.bankingfinancesystem;

@FunctionalInterface
public interface WithdrawalCheck {
    boolean isValid(double balance, double amount);
}
