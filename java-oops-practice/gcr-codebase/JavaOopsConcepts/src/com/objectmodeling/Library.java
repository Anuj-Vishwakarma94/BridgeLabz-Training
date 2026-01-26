package com.objectmodeling;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {

    String libraryname;
    ArrayList<Book> booklist = new ArrayList<>();

    Library(String libraryname) {
        this.libraryname = libraryname;
    }

    void addBook(Book book) {
        booklist.add(book);
    }

    void showLibraryBooks() {
        System.out.println("Books in " + libraryname + ":");
        for (Book book : booklist) {
            book.showBookDetails();
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // books exist independently
        Book book1 = new Book("Atomic Habits", "Poypee");
        Book book2 = new Book("Clean Code", "Chetan Bhagat");

        // libraries
        Library centralLibrary = new Library("Central Library");
        Library cityLibrary = new Library("City Library");

        // aggregation: libraries use book objects
        centralLibrary.addBook(book1);
        centralLibrary.addBook(book2);

        cityLibrary.addBook(book1);

        centralLibrary.showLibraryBooks();
        cityLibrary.showLibraryBooks();
        sc.close();
    }
}
