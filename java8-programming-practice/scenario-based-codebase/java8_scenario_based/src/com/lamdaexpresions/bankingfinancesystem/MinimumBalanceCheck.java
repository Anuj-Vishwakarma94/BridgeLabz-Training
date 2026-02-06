package com.lamdaexpresions.bankingfinancesystem;

@FunctionalInterface
public interface MinimumBalanceCheck {
    boolean check(double balance);
}
