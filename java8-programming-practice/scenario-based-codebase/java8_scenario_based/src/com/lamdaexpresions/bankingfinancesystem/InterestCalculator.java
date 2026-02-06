package com.lamdaexpresions.bankingfinancesystem;

@FunctionalInterface
public interface InterestCalculator {
    double calculate(double p, double r, double t);
}
