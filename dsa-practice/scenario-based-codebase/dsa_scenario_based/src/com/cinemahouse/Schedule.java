package com.cinemahouse;

class Schedule {
    private Show[] shows;
    private int count;

    public Schedule(int maxSize) {
        shows = new Show[maxSize];
        count = 0;
    }

    public void addShow(Show newShow) {
        if (count < shows.length) {
            shows[count] = newShow;
            count++;
        } else {
            System.out.println("Sorry, schedule is full!");
        }
    }

    public void bubbleSort() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - 1 - i; j++) {
                if (shows[j].isLaterThan(shows[j + 1])) {
                    // swap
                    Show temp = shows[j];
                    shows[j] = shows[j + 1];
                    shows[j + 1] = temp;
                }
            }
        }
    }

    public void showAll() {
        if (count == 0) {
            System.out.println("No movies in schedule yet...");
            return;
        }

        System.out.println("\nToday's Schedule:");
        System.out.println("-----------------");
        for (int i = 0; i < count; i++) {
            shows[i].print();
        }
        System.out.println("-----------------");
    }
}