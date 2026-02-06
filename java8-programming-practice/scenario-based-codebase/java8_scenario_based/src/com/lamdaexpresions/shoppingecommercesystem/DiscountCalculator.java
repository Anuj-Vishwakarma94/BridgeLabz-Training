package com.lamdaexpresions.shoppingecommercesystem;

@FunctionalInterface
public interface DiscountCalculator {
    double apply(double price);
}
