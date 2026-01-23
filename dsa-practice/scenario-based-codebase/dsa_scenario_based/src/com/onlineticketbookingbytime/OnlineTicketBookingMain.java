package com.onlineticketbookingbytime;

import java.util.Scanner;

public class OnlineTicketBookingMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EventSchedule schedule = new EventSchedule();
        int choice;

        do {
            System.out.println("\n--- Online Ticket Booking System ---");
            System.out.println("1. Add Event");
            System.out.println("2. Cancel Event");
            System.out.println("3. Display Events");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter event time: ");
                    int time = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter event name: ");
                    String name = sc.nextLine();

                    schedule.root = schedule.insertEvent(schedule.root, time, name);
                    System.out.println("Event Added");
                    break;

                case 2:
                    System.out.print("Enter event time to cancel: ");
                    int cancelTime = sc.nextInt();

                    schedule.root = schedule.cancelEvent(schedule.root, cancelTime);
                    System.out.println("Cancel Operation Done");
                    break;

                case 3:
                    System.out.println("Upcoming Events (Sorted by Time):");
                    schedule.displaySchedule(schedule.root);
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
