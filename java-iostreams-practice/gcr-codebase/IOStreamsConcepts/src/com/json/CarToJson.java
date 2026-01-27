package com.json;

import com.fasterxml.jackson.databind.ObjectMapper;

class Car {
    public String brand;
    public int year;

    Car(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }
}


public class CarToJson {
    public static void main(String[] args) throws Exception {
        Car car = new Car("Tesla", 2024);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(car));
    }
}
