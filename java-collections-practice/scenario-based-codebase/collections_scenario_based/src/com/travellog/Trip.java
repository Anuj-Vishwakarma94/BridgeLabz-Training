package com.travellog;
import java.io.Serializable;

public class Trip implements Serializable {

    private String city;
    private String country;
    private int durationDays;
    private String notes;

    public Trip(String city, String country, int durationDays, String notes) {
        this.city = city;
        this.country = country;
        this.durationDays = durationDays;
        this.notes = notes;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public int getDurationDays() {
        return durationDays;
    }

    public String getNotes() {
        return notes;
    }

    @Override
    public String toString() {
        return city + ", " + country + " | Days: " + durationDays;
    }
}