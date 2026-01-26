package com.encapsulation.librarymanagementsystem;

public class Book extends LibraryItem implements Reservable{
    private boolean reserved;

    public Book(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 21; // 21 days
    }

    @Override
    public void reserveItem() {
        reserved = true;
        System.out.println("Book reserved successfully.");
    }

    @Override
    public boolean checkAvailability() {
        return !reserved && !isIssued();
    }
}
