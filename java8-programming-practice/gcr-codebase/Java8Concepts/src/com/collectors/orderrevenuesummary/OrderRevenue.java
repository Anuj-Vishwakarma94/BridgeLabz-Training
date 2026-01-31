package com.collectors.orderrevenuesummary;

import java.util.*;
import java.util.stream.Collectors;

public class OrderRevenue {
    public static void main(String[] args) {

        List<Order> orders = Arrays.asList(
                new Order("Anuj", 500),
                new Order("Andrew", 300),
                new Order("Tristan", 700)
        );

        Map<String, Double> revenuePerCustomer =
                orders.stream()
                        .collect(Collectors.groupingBy(
                                Order::getCustomer,
                                Collectors.summingDouble(Order::getAmount)
                        ));

        System.out.println(revenuePerCustomer);
    }
}
