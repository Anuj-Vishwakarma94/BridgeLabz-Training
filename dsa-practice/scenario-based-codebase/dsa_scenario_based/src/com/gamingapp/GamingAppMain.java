package com.gamingapp;

import java.util.Scanner;

public class GamingAppMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LeaderBoard leaderboard = new LeaderBoard();
        int choice;

        do {
            System.out.println("\n--- Gaming Leaderboard ---");
            System.out.println("1. Add Player");
            System.out.println("2. Remove Player");
            System.out.println("3. Display Leaderboard");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter player name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter score: ");
                    int score = sc.nextInt();

                    leaderboard.root = leaderboard.insertPlayer(leaderboard.root, score, name);
                    System.out.println("Player Added");
                    break;

                case 2:
                    System.out.print("Enter score to remove: ");
                    int removeScore = sc.nextInt();

                    leaderboard.root = leaderboard.removePlayer(leaderboard.root, removeScore);
                    System.out.println("Remove Operation Done");
                    break;

                case 3:
                    System.out.println("Leaderboard (High to Low):");
                    leaderboard.displayLeaderboard(leaderboard.root);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 4);

        sc.close();
    }
}
