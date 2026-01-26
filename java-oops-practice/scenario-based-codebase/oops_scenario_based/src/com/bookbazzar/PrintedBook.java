package com.bookbazzar;
public class PrintedBook extends Book {

    public PrintedBook(String title, String author, double price, int stock) {
        super(title, author, price, stock);
    }

    @Override
    public double applyDiscount() {
        return price * 0.80; 
    }
}
