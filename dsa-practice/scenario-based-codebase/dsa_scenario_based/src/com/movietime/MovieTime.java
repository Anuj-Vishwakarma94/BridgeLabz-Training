package com.movietime;

import java.util.Scanner;

public class MovieTime {

    public static int convertToMinutes(String time) {
        String[] t = time.split(":");
        int hours = Integer.parseInt(t[0]);
        int minutes = Integer.parseInt(t[1]);
        return hours * 60 + minutes;
    }

    public static Movie[] insertionSort(Movie[] shows) {
        int n = shows.length;

        for (int i = 1; i < n; i++) {
            Movie key = shows[i];
            int keyTime = convertToMinutes(key.showTime);
            int j = i - 1;

            while (j >= 0 && convertToMinutes(shows[j].showTime) > keyTime) {
                shows[j + 1] = shows[j];
                j--;
            }
            shows[j + 1] = key;
        }
        return shows;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of movies: ");
        int n = sc.nextInt();
        sc.nextLine();

        Movie[] shows = new Movie[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter movie name: ");
            String name = sc.nextLine();

            System.out.print("Enter show time (HH:MM): ");
            String time = sc.nextLine();

            shows[i] = new Movie(name, time);
        }

        insertionSort(shows);

        System.out.println("\n------ Movie Theatre Show Listings ------\n");
        System.out.printf("%-30s %-10s%n", "Movie Name", "Show Time");
        System.out.println("------------------------------------------");

        for (Movie m : shows) {
            System.out.printf("%-30s %-10s%n", m.movieName, m.showTime);
        }
        sc.close();
    }
}
