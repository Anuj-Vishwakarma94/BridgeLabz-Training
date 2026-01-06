package com.eventease;

import java.util.List;

public class Event implements ISchedulable {

    private final int eventId;             
    protected String eventName;
    protected String location;
    protected String date;
    protected List<String> attendees;

    protected double venueCost;
    protected double serviceCost;
    protected double discount;
    protected double totalCost;

    private static int counter = 100;

    public Event(String eventName, String location, String date, List<String> attendees) {
        this.eventId = counter++;
        this.eventName = eventName;
        this.location = location;
        this.date = date;
        this.attendees = attendees;
        this.venueCost = 5000; 
        this.serviceCost = 0;
        this.discount = 0;
        calculateCost();
    }


    public Event(String eventName, String location, String date, List<String> attendees,
                 double serviceCost, double discount) {
        this(eventName, location, date, attendees);
        this.serviceCost = serviceCost;
        this.discount = discount;
        calculateCost();
    }

    protected void calculateCost() {
        totalCost = (venueCost + serviceCost) - discount;
    }

    public int getEventId() {
        return eventId; 
    }

    @Override
    public void schedule() {
        System.out.println("Event scheduled on " + date);
    }

    @Override
    public void reschedule(String newDate) {
        this.date = newDate;
        System.out.println("Event rescheduled to " + newDate);
    }

    @Override
    public void cancel() {
        System.out.println("Event cancelled: " + eventName);
    }

    public double getTotalCost() {
        return totalCost;
    }
}
