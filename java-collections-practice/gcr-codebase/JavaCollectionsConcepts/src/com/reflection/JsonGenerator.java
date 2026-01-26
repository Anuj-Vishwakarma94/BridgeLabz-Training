package com.reflection;

import java.lang.reflect.Field;

class Employee {
    String name = "Anuj";
    int salary = 50000;
}

public class JsonGenerator {
    public static void main(String[] args) throws Exception {
        Employee e = new Employee();
        Class<?> cls = e.getClass();
        StringBuilder json = new StringBuilder("{");

        Field[] fields = cls.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            json.append("\"").append(fields[i].getName()).append("\":\"")
                .append(fields[i].get(e)).append("\"");
            if (i < fields.length - 1) json.append(",");
        }

        json.append("}");
        System.out.println(json);
    }
}
