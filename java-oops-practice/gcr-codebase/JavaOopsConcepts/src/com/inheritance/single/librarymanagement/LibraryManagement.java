package com.inheritance.single.librarymanagement;

public class LibraryManagement {

    public static void main(String[] args) {

        // Single inheritance demonstration
        Book book = new Author(
                "Effective Java",
                2018,
                "Joshua Bloch",
                "Expert in Java best practices"
        );

        book.displayInfo();
    }
}
