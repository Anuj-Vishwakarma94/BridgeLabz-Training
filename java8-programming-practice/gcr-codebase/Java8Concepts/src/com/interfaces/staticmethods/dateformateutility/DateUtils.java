package com.interfaces.staticmethods.dateformateutility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface DateUtils {

    public static String formatDate(LocalDate date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }
}

