package com.swiftcart;
public interface Checkout {
    double generateBill();
    void applyDiscount(double couponAmount);
}
