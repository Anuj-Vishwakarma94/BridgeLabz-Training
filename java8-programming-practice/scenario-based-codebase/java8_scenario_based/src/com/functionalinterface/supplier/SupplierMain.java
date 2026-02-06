package com.functionalinterface.supplier;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.function.Supplier;

public class SupplierMain {

    public static void main(String[] args) {

        Supplier<Integer> otpSupplier =
                () -> 100000 + new Random().nextInt(900000);
        System.out.println(otpSupplier.get());

        Supplier<Integer> studentIdSupplier =
                () -> new Random().nextInt(100000);
        System.out.println(studentIdSupplier.get());

        Supplier<LocalDateTime> dateTimeSupplier =
                LocalDateTime::now;
        System.out.println(dateTimeSupplier.get());

        Supplier<String> welcomeSupplier =
                () -> "Welcome to our system";
        System.out.println(welcomeSupplier.get());

        Supplier<String> couponSupplier =
                () -> "DISC" + new Random().nextInt(1000);
        System.out.println(couponSupplier.get());
    }
}

