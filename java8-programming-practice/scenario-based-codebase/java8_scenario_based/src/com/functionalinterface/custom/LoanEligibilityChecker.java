package com.functionalinterface.custom;

@FunctionalInterface
public interface LoanEligibilityChecker {
    boolean check(double salary);
}

