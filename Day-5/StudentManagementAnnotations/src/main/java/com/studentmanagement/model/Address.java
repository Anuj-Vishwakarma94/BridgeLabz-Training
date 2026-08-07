package com.studentmanagement.model;

import org.springframework.stereotype.Component;

@Component
public class Address {

    private String city = "Bhopal";
    private String state = "Madhya Pradesh";

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}