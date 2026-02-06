package com.lamdaexpresions.shoppingecommercesystem;

import java.util.*;

public class ProductSort {

    public static void sortByPrice(List<Product> list) {
        list.sort((p1, p2) -> Double.compare(p1.price, p2.price));
    }
}
