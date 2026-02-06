package com.optionalclass.ecommercesystem;

public class EcommerceService {

    public static void main(String[] args) {

        Product product = new Product(
                "Laptop",
                null,
                null,
                new Seller("TechStore"),
                new Coupon("SAVE10"),
                null
        );

        double discount = product.getDiscount()
                .orElse(5.0);

        product.getCoupon()
                .ifPresent(c -> System.out.println(c.getCode()));

        product.getSeller()
                .ifPresent(s -> System.out.println(s.getName()));

        String description = product.getDescription()
                .orElse("No description available");

        product.getDeliveryPartner()
                .ifPresent(d -> System.out.println(d.getCompany()));

        System.out.println(discount);
        System.out.println(description);
    }
}

