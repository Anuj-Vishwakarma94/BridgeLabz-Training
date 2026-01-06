package com.swiftcart;
public class PerishableProduct extends Product {

    public PerishableProduct(String name, double price, String category, int quantity) {
        super(name, price, category, quantity);   // 👈 UPDATED
    }

    @Override
    public double applyDiscount() {
        return (getPrice() * getQuantity()) * 0.90;   // 10% OFF
    }
}
