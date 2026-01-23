package com.musicapp;

import java.util.Scanner;

public class MusicAppMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Music library = new Music();
        int choice;

        do {
            System.out.println("\n--- Music App ---");
            System.out.println("1. Add Song");
            System.out.println("2. Search Song by Track ID");
            System.out.println("3. Display Playlist");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter song title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter track ID: ");
                    int trackId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter artist name: ");
                    String artist = sc.nextLine();

                    library.root = library.insert(library.root, title, trackId, artist);
                    System.out.println("Song Added");
                    break;

                case 2:
                    System.out.print("Enter track ID to search: ");
                    int searchId = sc.nextInt();

                    SongNode result = library.searchByTrackId(library.root, searchId);
                    if (result != null) {
                        System.out.println(result.title + " | " + result.trackId + " | " + result.artist);
                    } else {
                        System.out.println("Track Not Found");
                    }
                    break;

                case 3:
                    System.out.println("Playlist (Alphabetical Order):");
                    library.inorder(library.root);
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
