package com.bookshelf;

import java.util.*;

public class BookShelf {

    static HashMap<String, LinkedList<String>> books = new HashMap<>();
    static HashSet<String> addedBooks = new HashSet<>();

    static void addBook(String genre, String name, String author) {

        String book = name + " by " + author;

        if (addedBooks.contains(book)) {
            System.out.println("Book already exists");
            return;
        }

        books.putIfAbsent(genre, new LinkedList<>());
        books.get(genre).add(book);
        addedBooks.add(book);

        System.out.println("Book added");
    }

    static void borrowBook(String genre, String name, String author) {

        String book = name + " by " + author;

        if (!books.containsKey(genre) || !books.get(genre).remove(book)) {
            System.out.println("Book not available");
            return;
        }

        addedBooks.remove(book);
        System.out.println("Book borrowed");
    }

    static void showBooks() {
        for (String genre : books.keySet()) {
            System.out.println(genre + " : " + books.get(genre));
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1 Add Book");
            System.out.println("2 Borrow Book");
            System.out.println("3 Show Books");
            System.out.println("4 Exit");
            System.out.print("Choose from the above options: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 4) {
                break;
            }

            if (choice == 1) {
                System.out.print("Genre: ");
                String genre = sc.nextLine();

                System.out.print("Book Name: ");
                String name = sc.nextLine();

                System.out.print("Author: ");
                String author = sc.nextLine();

                addBook(genre, name, author);
            }

            else if (choice == 2) {
                System.out.print("Genre: ");
                String genre = sc.nextLine();

                System.out.print("Book Name: ");
                String name = sc.nextLine();

                System.out.print("Author: ");
                String author = sc.nextLine();

                borrowBook(genre, name, author);
            }

            else if (choice == 3) {
                showBooks();
            }
        }
        sc.close();
    }
}
