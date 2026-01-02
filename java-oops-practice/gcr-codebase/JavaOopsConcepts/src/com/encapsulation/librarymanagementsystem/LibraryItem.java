package com.encapsulation.librarymanagementsystem;

public abstract class LibraryItem {
    // Encapsulation
    private int itemId;
    private String title;
    private String author;

    // Secured borrower details
    private String borrowerName;

    // Constructor
    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Abstract method
    public abstract int getLoanDuration();

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }

    // Controlled access to borrower data
    public void issueItem(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    protected boolean isIssued() {
        return borrowerName != null;
    }
}
