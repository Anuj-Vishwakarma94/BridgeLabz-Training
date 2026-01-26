package com.swiftcart;
public class Product {
    private String name;
    private double price;
    private String category;
    private int quantity;   // 👈 NEW

    public Product(String name, double price, String category, int quantity) {  // 👈 UPDATED
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public int getQuantity() { return quantity; }

    public double applyDiscount() {
        return price * quantity;   // 👈 price * qty
    }
}
