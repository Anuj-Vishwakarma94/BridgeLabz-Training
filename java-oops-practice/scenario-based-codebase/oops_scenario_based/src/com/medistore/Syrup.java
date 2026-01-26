package com.medistore;

import java.time.LocalDate;

public class Syrup extends Medicine {

    public Syrup(String name, double price, LocalDate expiryDate) {
        super(name, price, expiryDate);
    }

    @Override
    public boolean checkExpiry() {
        return LocalDate.now().isAfter(expiryDate);
    }
}
