package com.fitnesstracker;
import java.util.Scanner;

public class FitnessTracker {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        User[] users = new User[20]; // small group
        int count = 0;

        System.out.println(" FitnessTracker – Daily Rankings ");
        System.out.println("----------------------------------");

        while (true) {
            System.out.println("\n1. Add User");
            System.out.println("2. Update Steps");
            System.out.println("3. Show Leaderboard");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("User name: ");
                    String name = sc.nextLine();

                    System.out.print("Steps: ");
                    int steps = sc.nextInt();
                    sc.nextLine();

                    users[count++] = new User(name, steps);

                    // real-time sorting
                    StepSorter.bubbleSort(users, count);
                    System.out.println("User added and rankings updated.");
                    break;

                case 2:
                    System.out.print("Enter user name: ");
                    String uname = sc.nextLine();

                    boolean found = false;
                    for (int i = 0; i < count; i++) {
                        if (users[i].getName().equals(uname)) {
                            System.out.print("Enter updated steps: ");
                            int newSteps = sc.nextInt();
                            sc.nextLine();

                            users[i].setSteps(newSteps);
                            StepSorter.bubbleSort(users, count);
                            found = true;
                            System.out.println("Steps updated and rankings updated.");
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("User not found.");
                    }
                    break;

                case 3:
                    System.out.println("\nDaily Step Leaderboard:");
                    StepSorter.display(users, count);
                    break;

                case 4:
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
