package com.eventease;

import java.util.List;

public class BirthdayEvent extends Event {

    private String birthdayPerson;

    public BirthdayEvent(String name, String location, String date,
                         List<String> attendees, String birthdayPerson,
                         double serviceCost, double discount) {

        super(name, location, date, attendees, serviceCost, discount);
        this.birthdayPerson = birthdayPerson;
    }

    @Override
    public void schedule() {
        System.out.println("🎂 Birthday Party for " + birthdayPerson +
                " scheduled on " + date);
    }
}
