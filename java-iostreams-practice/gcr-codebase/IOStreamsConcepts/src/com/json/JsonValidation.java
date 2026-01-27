package com.json;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonValidation {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        String json = "{ \"name\": \"Anuj\", \"age\": 22 }";

        try {
            mapper.readTree(json);
            System.out.println("Valid JSON");
        } catch (Exception e) {
            System.out.println("Invalid JSON");
        }
    }
}
