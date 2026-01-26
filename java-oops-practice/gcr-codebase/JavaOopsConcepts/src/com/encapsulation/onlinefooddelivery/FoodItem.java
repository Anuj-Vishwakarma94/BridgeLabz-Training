package com.encapsulation.onlinefooddelivery;

public abstract class FoodItem {

    // Encapsulation
    private String itemName;
    private double price;
    private int quantity;

    // Constructor
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Abstract method
    public abstract double calculateTotalPrice();

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }

    // Protected getters (restricted access)
    protected double getPrice() {
        return price;
    }

    protected int getQuantity() {
        return quantity;
    }
}
