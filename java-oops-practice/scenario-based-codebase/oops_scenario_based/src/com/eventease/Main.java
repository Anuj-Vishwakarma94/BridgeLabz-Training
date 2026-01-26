package com.eventease;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Organizer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Organizer Email: ");
        String email = sc.nextLine();

        User user = new User(name, email);

        System.out.println("\nSelect Event Type:");
        System.out.println("1. Birthday Event");
        System.out.println("2. Conference Event");
        int choice = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter Event Name: ");
        String eventName = sc.nextLine();

        System.out.print("Enter Location: ");
        String location = sc.nextLine();

        System.out.print("Enter Date (dd-mm-yyyy): ");
        String date = sc.nextLine();

        System.out.print("Enter number of attendees: ");
        int count = sc.nextInt();
        sc.nextLine();

        List<String> attendees = new ArrayList<>();

        for(int i = 1; i <= count; i++) {
            System.out.print("Enter attendee " + i + ": ");
            attendees.add(sc.nextLine());
        }

        System.out.print("Enter Service Cost (catering/decoration): ");
        double serviceCost = sc.nextDouble();

        System.out.print("Enter Discount: ");
        double discount = sc.nextDouble();
        sc.nextLine();

        if(choice == 1) {

            System.out.print("Enter Birthday Person Name: ");
            String person = sc.nextLine();

            BirthdayEvent b = new BirthdayEvent(
                    eventName,
                    location,
                    date,
                    attendees,
                    person,
                    serviceCost,
                    discount
            );

            b.schedule();
            System.out.println("Total Cost = " + b.getTotalCost());
        }
        else {

            System.out.print("Enter Conference Topic: ");
            String topic = sc.nextLine();

            ConferenceEvent c = new ConferenceEvent(
                    eventName,
                    location,
                    date,
                    attendees,
                    topic,
                    serviceCost,
                    discount
            );

            c.schedule();
            System.out.println("Total Cost = " + c.getTotalCost());
        }

        sc.close();
    }
}
