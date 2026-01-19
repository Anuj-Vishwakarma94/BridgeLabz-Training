package com.artexpo;

public class Artist {
    private String name;
    private int timeInMinutes;

    public Artist(String name, int hour, int minute) {
        this.name = name;
        this.timeInMinutes = hour * 60 + minute;
    }

    public int getTimeInMinutes() {
        return timeInMinutes;
    }

    public String getFormattedTime() {
        int hour = timeInMinutes / 60;
        int minute = timeInMinutes % 60;
        return String.format("%02d:%02d", hour, minute);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " | Time: " + getFormattedTime();
    }
}
