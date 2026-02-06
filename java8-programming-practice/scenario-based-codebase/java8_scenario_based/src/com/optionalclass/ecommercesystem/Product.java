package com.optionalclass.ecommercesystem;

import java.util.Optional;

public class Product {

    private String name;
    private Double discount;
    private String description;
    private Seller seller;
    private Coupon coupon;
    private DeliveryPartner deliveryPartner;

    public Product(String name, Double discount, String description,
                   Seller seller, Coupon coupon, DeliveryPartner deliveryPartner) {
        this.name = name;
        this.discount = discount;
        this.description = description;
        this.seller = seller;
        this.coupon = coupon;
        this.deliveryPartner = deliveryPartner;
    }

    public Optional<Double> getDiscount() {
        return Optional.ofNullable(discount);
    }

    public Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }

    public Optional<Seller> getSeller() {
        return Optional.ofNullable(seller);
    }

    public Optional<Coupon> getCoupon() {
        return Optional.ofNullable(coupon);
    }

    public Optional<DeliveryPartner> getDeliveryPartner() {
        return Optional.ofNullable(deliveryPartner);
    }

    public String getName() {
        return name;
    }
}

