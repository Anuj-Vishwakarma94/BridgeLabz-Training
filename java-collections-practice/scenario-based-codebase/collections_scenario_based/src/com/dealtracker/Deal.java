package com.dealtracker;

import java.time.LocalDate;

public class Deal {

    private String code;
    private LocalDate validTill;
    private int discount;
    private int minPurchase;

    public Deal(String code, LocalDate validTill, int discount, int minPurchase) {
        this.code = code;
        this.validTill = validTill;
        this.discount = discount;
        this.minPurchase = minPurchase;
    }

    public int getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return code + " | " + discount + "% | Valid Till: " + validTill + " | Min ₹" + minPurchase;
    }
}