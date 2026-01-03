package com.linkedlist.circularlinkedlist.onlineticketreservationsystem;

public class OnlineTicketReservationSystem {
    public static void main(String[] args) {

        TicketReservationSystem system = new TicketReservationSystem();

        system.addTicket(101, "Andrew", "Inception", "A10", "10:30 AM");
        system.addTicket(102, "Anuj", "Avatar", "B12", "11:00 AM");
        system.addTicket(103, "Tristan", "Inception", "A11", "10:35 AM");

        system.displayTickets();

        System.out.println("\n--- Search by Customer ---");
        system.searchByCustomer("Andrew");

        System.out.println("\n--- Search by Movie ---");
        system.searchByMovie("Inception");

        System.out.println("\n--- Remove Ticket (ID = 102) ---");
        system.removeTicket(102);
        system.displayTickets();

        System.out.println("\n--- Count Tickets ---");
        system.countTickets();
    }
}