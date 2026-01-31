package com.interfaces.staticmethods.dateformateutility;

import java.time.LocalDate;

public class DateFormatMain {

    private static void displayDates() {

        LocalDate today = LocalDate.now();

        System.out.println("DD/MM/YYYY: " + DateUtils.formatDate(today, "dd/MM/yyyy"));

        System.out.println("YYYY-MM-DD: " + DateUtils.formatDate(today, "yyyy-MM-dd"));
    }

    public static void main(String[] args) {
        displayDates();
    }
}
