package com.encapsulation.librarymanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class LibraryManagementSystem {
    public static void main(String[] args) {

        List<LibraryItem> items = new ArrayList<>();

        LibraryItem book = new Book(1, "Clean Code", "Robert Martin");
        LibraryItem magazine = new Magazine(2, "Java Monthly", "Oracle");
        LibraryItem dvd = new DVD(3, "Inception", "Christopher Nolan");

        items.add(book);
        items.add(magazine);
        items.add(dvd);

        for (LibraryItem item : items) {

            item.getItemDetails();
            System.out.println("Loan Duration: " +
                    item.getLoanDuration() + " days");

            if (item instanceof Reservable) {
                Reservable reservableItem = (Reservable) item;
                System.out.println("Available: " +
                        reservableItem.checkAvailability());
                reservableItem.reserveItem();
            }

            System.out.println("------------------------");
        }
    }
}
