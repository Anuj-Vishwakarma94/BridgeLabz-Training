package com.medistore;

import java.time.LocalDate;

public abstract class Medicine implements ISellable {

    private String name;
    private double price;         
    private int quantity;          
    protected LocalDate expiryDate;

    public Medicine(String name, double price, LocalDate expiryDate) {
        this(name, price, expiryDate, 50); 
    }

    public Medicine(String name, double price, LocalDate expiryDate, int quantity) {
        this.name = name;
        this.price = price;
        this.expiryDate = expiryDate;
        this.quantity = quantity;
    }

    protected void reduceStock(int units) {
        if (units <= quantity) {
            quantity -= units;
        }
        else {
            throw new IllegalArgumentException("Insufficient stock");
        }
    }
    
    private double applyDiscount(double total) {
        return total > 500 ? total * 0.90 : total; 
    }

    @Override
    public double sell(int units) {
        if (checkExpiry()) {
            throw new IllegalStateException("Medicine expired");
        }
        reduceStock(units);
        double total = price * units;
        return applyDiscount(total);
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
