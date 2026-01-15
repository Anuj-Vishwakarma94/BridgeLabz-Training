package com.smartshelf;
import java.util.Scanner;

public class SmartShelfApp{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Book[] books = new Book[50]; // small list
        int count = 0;

        while (true) {
            System.out.println("\n1. Add Book");
            System.out.println("2. Show Books");
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

                    // real-time sorting
                    SmartShelf.insertionSort(books, count);

                    System.out.println("Book added and shelf sorted");
                    break;

                case 2:
                    System.out.println("\nBooks on Shelf:");
                    SmartShelf.showBooks(books, count);
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
