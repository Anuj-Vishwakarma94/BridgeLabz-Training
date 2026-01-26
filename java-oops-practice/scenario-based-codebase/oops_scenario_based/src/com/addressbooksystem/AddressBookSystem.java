package com.addressbooksystem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class AddressBookSystem {

    static ArrayList<Contact> contacts = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println(" DigiContact – Address Book ");
        System.out.println("------------------------------");

        while (true) {
            System.out.println("\n1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Search by City/State");
            System.out.println("5. Display All Contacts");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addContact(sc);
                    break;

                case 2:
                    editContact(sc);
                    break;

                case 3:
                    deleteContact(sc);
                    break;

                case 4:
                    searchByLocation(sc);
                    break;

                case 5:
                    displaySorted();
                    break;

                case 6:
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option");
            }
        }
    }

    //  Add Contact with duplicate validation
    static void addContact(Scanner sc) {

        System.out.print("First Name: ");
        String fn = sc.nextLine();

        System.out.print("Last Name: ");
        String ln = sc.nextLine();

        System.out.print("Phone: ");
        String phone = sc.nextLine();

        for (Contact c : contacts) {
            if (c.getFullName().equalsIgnoreCase(fn + " " + ln)
                    || c.getPhone().equals(phone)) {
                System.out.println("Duplicate contact found!");
                return;
            }
        }

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("City: ");
        String city = sc.nextLine();

        System.out.print("State: ");
        String state = sc.nextLine();

        System.out.print("Zip: ");
        String zip = sc.nextLine();

        Address address = new Address(city, state, zip);
        contacts.add(new Contact(fn, ln, phone, email, address));

        System.out.println("Contact added successfully.");
    }

    // Edit Contact
    static void editContact(Scanner sc) {
        System.out.print("Enter full name to edit: ");
        String name = sc.nextLine();

        for (Contact c : contacts) {
            if (c.getFullName().equalsIgnoreCase(name)) {

                System.out.print("New Phone: ");
                String phone = sc.nextLine();

                System.out.print("New Email: ");
                String email = sc.nextLine();

                System.out.print("New City: ");
                String city = sc.nextLine();

                System.out.print("New State: ");
                String state = sc.nextLine();

                System.out.print("New Zip: ");
                String zip = sc.nextLine();

                c.update(phone, email, new Address(city, state, zip));
                System.out.println("Contact updated.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    //Delete Contact
    static void deleteContact(Scanner sc) {
        System.out.print("Enter full name to delete: ");
        String name = sc.nextLine();

        contacts.removeIf(c ->
                c.getFullName().equalsIgnoreCase(name));

        System.out.println("Contact deleted if existed.");
    }

    // Search by City or State
    static void searchByLocation(Scanner sc) {
        System.out.print("Enter city or state: ");
        String key = sc.nextLine();

        for (Contact c : contacts) {
            Address a = c.getAddress();
            if (a.getCity().equalsIgnoreCase(key)
                    || a.getState().equalsIgnoreCase(key)) {
                c.display();
            }
        }
    }

    //  Display sorted contacts
    static void displaySorted() {

        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        Collections.sort(contacts, Comparator.comparing(Contact::getFullName));

        for (Contact c : contacts) {
            c.display();
        }
    }
}
