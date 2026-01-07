package com.bookbazzar;
public abstract class Book implements IDiscountable {

    private String title;
    private String author;
    protected double price;
    private int stock;

    public Book(String title, String author, double price, int stock) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.stock = stock;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void reduceStock(int qty) {
        if (qty <= stock) stock -= qty;
        else System.out.println("Insufficient stock for " + title);
    }

    public abstract double applyDiscount();
}
