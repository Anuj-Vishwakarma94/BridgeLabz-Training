package com.universitydigitalrecordsystem;

import java.util.Scanner;

public class UniversityDigitalRecordMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Record tree = new Record();
        int choice;

        do {
            System.out.println("\n--- University Digital Record System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display All Records");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter roll number: ");
                    int key = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter student name: ");
                    String data = sc.nextLine();

                    tree.root = tree.insert(tree.root, key, data);
                    System.out.println("Student Added");
                    break;

                case 2:
                    System.out.print("Enter roll number to search: ");
                    int searchKey = sc.nextInt();

                    Node result = tree.search(tree.root, searchKey);
                    if (result != null) {
                        System.out.println(result.key + " | " + result.data);
                    } else {
                        System.out.println("Record Not Found");
                    }
                    break;

                case 3:
                    System.out.print("Enter roll number to delete: ");
                    int deleteKey = sc.nextInt();

                    tree.root = tree.delete(tree.root, deleteKey);
                    System.out.println("Delete Operation Done");
                    break;

                case 4:
                    System.out.println("Sorted Student Records:");
                    tree.inorder(tree.root);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 5);
        sc.close();
    }
}
