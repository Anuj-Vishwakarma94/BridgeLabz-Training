package com.eventease;

import java.util.List;

public class ConferenceEvent extends Event {

    private String topic;

    public ConferenceEvent(String name, String location, String date,
                           List<String> attendees, String topic,
                           double serviceCost, double discount) {

        super(name, location, date, attendees, serviceCost, discount);
        this.topic = topic;
    }

    @Override
    public void schedule() {
        System.out.println("📢 Conference on '" + topic +
                "' scheduled on " + date);
    }
}
