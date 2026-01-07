package com.bookbazzar;

import java.util.*;

public class Order {

    private String userName;
    private Map<Book, Integer> orderedBooks = new LinkedHashMap<>();
    private String status = "CREATED";

    public Order(String userName) {
        this.userName = userName;
    }

    public void addBook(Book book, int qty) {
        orderedBooks.put(book, qty);
        book.reduceStock(qty);
    }

    private void updateStatus(String newStatus) { 
        status = newStatus;
    }

    public void confirmPayment() {
        updateStatus("PAID");
    }

    public double getTotalCost() {
        double total = 0;

        for (Book b : orderedBooks.keySet()) {
            int qty = orderedBooks.get(b);
            total += b.applyDiscount() * qty;
        }
        return total;
    }

    public void showSummary() {
        System.out.println("\nOrder Summary:");
        for (Book b : orderedBooks.keySet()) {
            System.out.println("Book: " + b.getTitle() +
                    " | Qty: " + orderedBooks.get(b));
        }
    }

    public String getStatus() {
        return status;
    }
}
