package com.tourmate;
abstract class Trip implements IBookable {
    protected String destination;
    protected int duration;
    protected Transport transport;
    protected Hotel hotel;
    protected Activity activity;

    public Trip(String destination, int duration,
                Transport transport, Hotel hotel, Activity activity) {
        this.destination = destination;
        this.duration = duration;
        this.transport = transport;
        this.hotel = hotel;
        this.activity = activity;
    }

    // Operator-like total budget calculation
    public double getTotalBudget() {
        return transport.getCost()
             + hotel.getCost()
             + activity.getCost();
    }
}
