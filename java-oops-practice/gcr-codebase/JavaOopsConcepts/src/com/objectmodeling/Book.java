package com.objectmodeling;

class Book {

    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    void showBookDetails() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}
