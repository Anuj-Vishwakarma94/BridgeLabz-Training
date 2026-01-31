package com.lambdaexpression.notificationfiltering;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NotificationFiltering {
    public static void main(String[] args) {

        List<Alert> alerts = Arrays.asList(
                new Alert("Heart rate high", "CRITICAL"),
                new Alert("Appointment reminder", "INFO"),
                new Alert("Low oxygen level", "CRITICAL"),
                new Alert("Medicine time", "NORMAL")
        );

        // Predicate using lambda
        Predicate<Alert> criticalOnly = alert -> alert.getType().equals("CRITICAL");

        List<Alert> filteredAlerts = alerts.stream()
                .filter(criticalOnly)
                .collect(Collectors.toList());

        filteredAlerts.forEach(System.out::println);
    }
}
