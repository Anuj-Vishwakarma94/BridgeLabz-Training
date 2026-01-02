package com.encapsulation.librarymanagementsystem;

public class Magazine extends LibraryItem{
    public Magazine(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // 7 days
    }
}
