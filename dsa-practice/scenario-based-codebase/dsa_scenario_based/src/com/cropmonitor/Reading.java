package com.cropmonitor;

class Reading {
    String time;
    double temp;

    public Reading(String time, double temp) {
        this.time = time;
        this.temp = temp;
    }

    public boolean isAfter(Reading other) {
        return this.time.compareTo(other.time) > 0;
    }

    public void show() {
        System.out.println(time + " " + temp);
    }
}