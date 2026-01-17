package com.cinemahouse;

class Show {
    String movie;
    String time;

    public Show(String movie, String time) {
        this.movie = movie;
        this.time = time;
    }

    // Simple way to compare times (expects HH:MM format)
    public boolean isLaterThan(Show other) {
        return this.time.compareTo(other.time) > 0;
    }

    public void print() {
        System.out.println(time + "   " + movie);
    }
}