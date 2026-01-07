package com.bookbazzar;

public class EBook extends Book {

    public EBook(String title, String author, double price) {
        super(title, author, price, 0);
    }

    @Override
    public void reduceStock(int qty) {
    }

    @Override
    public int getStock() {
        return 0;   
    }

    @Override
    public double applyDiscount() {
        return price * 0.90;   
    }
}
