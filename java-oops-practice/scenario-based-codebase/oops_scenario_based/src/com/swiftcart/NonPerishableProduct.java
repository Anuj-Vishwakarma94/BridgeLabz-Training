package com.swiftcart;
public class NonPerishableProduct extends Product {

    public NonPerishableProduct(String name, double price, String category, int quantity) {
        super(name, price, category, quantity);   // 👈 UPDATED
    }

    @Override
    public double applyDiscount() {
        return (getPrice() * getQuantity()) * 0.95;   // 5% OFF
    }
}
