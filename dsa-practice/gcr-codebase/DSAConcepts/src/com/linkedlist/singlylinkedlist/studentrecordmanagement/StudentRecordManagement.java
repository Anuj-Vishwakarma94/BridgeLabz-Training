package com.linkedlist.singlylinkedlist.studentrecordmanagement;

import java.util.Scanner;

public class StudentRecordManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentLinkedList list = new StudentLinkedList();
        int choice;

        do {
            System.out.println("\n--- Student Record Management ---");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Delete by Roll No");
            System.out.println("5. Search by Roll No");
            System.out.println("6. Update Grade");
            System.out.println("7. Display All");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> list.addAtBeginning(1, "Anuj", 21, 'A');
                case 2 -> list.addAtEnd(2, "Andrew", 21, 'B');
                case 3 -> list.addAtPosition(2, 3, "Neymar", 29, 'A');
                case 4 -> list.deleteByRollNo(2);
                case 5 -> list.searchStudent(1);
                case 6 -> list.updateGrade(1, 'A');
                case 7 -> list.displayAll();
                case 8 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 8);

        sc.close();
    }
}