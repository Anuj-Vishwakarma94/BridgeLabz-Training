package com.smartlibrary;
import java.util.Scanner;

public class SmartLibrary {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Book[] books = new Book[30]; 
        int count = 0;

        System.out.println(" SmartLibrary – Borrowed Books ");
        System.out.println("---------------------------------");

        while (true) {
            System.out.println("\n1. Borrow Book");
            System.out.println("2. Show Borrowed Books");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();

                    books[count] = new Book(title);
                    count++;

                    // keep list sorted after every insertion
                    LibraryManager.insertionSort(books, count);

                    System.out.println("Book added and list sorted");
                    break;

                case 2:
                    System.out.println("\nBorrowed Books (Alphabetical Order):");
                    LibraryManager.showBooks(books, count);
                    break;

                case 3:
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
