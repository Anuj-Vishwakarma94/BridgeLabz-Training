package com.smartshelf;
public class SmartShelf {

    // Insertion Sort (A → Z)
    public static void insertionSort(Book[] books, int size) {
        for (int i = 1; i < size; i++) {
            Book key = books[i];
            int j = i - 1;

            while (j >= 0 && books[j].title.compareToIgnoreCase(key.title) > 0) {
                books[j + 1] = books[j];
                j--;
            }
            books[j + 1] = key;
        }
    }

    public static void showBooks(Book[] books, int size) {
        if (size == 0) {
            System.out.println("No books in shelf");
            return;
        }

        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + ". " + books[i].title);
        }
    }
}
