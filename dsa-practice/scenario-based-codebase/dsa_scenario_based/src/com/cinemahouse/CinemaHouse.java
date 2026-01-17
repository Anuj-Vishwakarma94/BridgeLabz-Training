package com.cinemahouse;

import java.util.Scanner;

public class CinemaHouse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Schedule schedule = new Schedule(10);  // max 10 movies

        System.out.println("=== Local Cinema - Add Shows ===");
        System.out.println("Enter movies (type 'done' when finished)\n");

        while (true) {
            System.out.print("Movie name: ");
            String name = sc.nextLine().trim();

            if (name.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Time (HH:MM): ");
            String time = sc.nextLine().trim();

            Show newShow = new Show(name, time);
            schedule.addShow(newShow);
        }

        // Sort using bubble sort
        schedule.bubbleSort();

        // Show result
        schedule.showAll();

        System.out.println("Have a great movie day! ");
        sc.close();
    }
}