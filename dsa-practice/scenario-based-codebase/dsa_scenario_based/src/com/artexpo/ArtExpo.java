package com.artexpo;

import java.util.Scanner;

public class ArtExpo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of artists: ");
        int n = sc.nextInt();
        sc.nextLine();

        ArtistRegistry registry = new ArtistRegistry(n);

        for (int i = 0; i < n; i++) {

            System.out.print("Artist Name: ");
            String name = sc.nextLine();

            System.out.print("Hour (0-23): ");
            int hour = sc.nextInt();

            System.out.print("Minute (0-59): ");
            int minute = sc.nextInt();
            sc.nextLine();

            registry.addArtist(new Artist(name, hour, minute));
        }

        System.out.println("\nArtists Sorted by Registration Time:");
        registry.displayArtists();

        sc.close();
    }
}
