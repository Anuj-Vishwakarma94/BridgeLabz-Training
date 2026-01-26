package com.tourmate;
class InternationalTrip extends Trip {

    public InternationalTrip(String destination, int duration,
                             Transport transport, Hotel hotel, Activity activity) {
        super(destination, duration, transport, hotel, activity);
    }

    @Override
    public void book() {
        System.out.println("Booking international trip to " + destination);
        System.out.println("Passport & visa verification required.");
        System.out.println("Total Budget: ₹" + getTotalBudget());
    }

    @Override
    public void cancel() {
        System.out.println("International trip cancelled with refund rules.");
    }
}
