package com.encapsulation.librarymanagementsystem;

public class DVD extends LibraryItem implements Reservable{
    private boolean reserved;

    public DVD(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 3; // 3 days
    }

    @Override
    public void reserveItem() {
        reserved = true;
        System.out.println("DVD reserved successfully.");
    }

    @Override
    public boolean checkAvailability() {
        return !reserved && !isIssued();
    }
}
