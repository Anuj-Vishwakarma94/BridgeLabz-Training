package com.lamdaexpresions.shoppingecommercesystem;

@FunctionalInterface
public interface DeliveryCheck {
    boolean isFree(double amount);
}
