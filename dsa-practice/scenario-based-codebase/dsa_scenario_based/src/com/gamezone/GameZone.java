package com.gamezone;

import java.util.Scanner;

public class GameZone {

    public static void quickSort(Player[] players, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(players, low, high);
            quickSort(players, low, pivotIndex - 1);
            quickSort(players, pivotIndex + 1, high);
        }
    }

    private static int partition(Player[] players, int low, int high) {
        int pivot = players[high].score;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (players[j].score >= pivot) {
                i++;
                Player temp = players[i];
                players[i] = players[j];
                players[j] = temp;
            }
        }

        Player temp = players[i + 1];
        players[i + 1] = players[high];
        players[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();
        sc.nextLine();

        Player[] players = new Player[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter player name: ");
            String name = sc.nextLine();

            System.out.print("Enter score: ");
            int score = sc.nextInt();
            sc.nextLine();

            players[i] = new Player(name, score);
        }

        quickSort(players, 0, players.length - 1);

        System.out.println("\nGameZone Leaderboard:");
        for (Player p : players) {
            System.out.println(p.name + " - " + p.score);
        }

        sc.close();
    }
}
