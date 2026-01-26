package com.annotation;

import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class JsonUser {
    @JsonField(name = "user_name")
    String name = "Anuj";

    @JsonField(name = "user_age")
    int age = 22;
}

public class JsonSerializer {
    public static void main(String[] args) throws Exception {
        JsonUser u = new JsonUser();
        StringBuilder json = new StringBuilder("{");

        Field[] fields = JsonUser.class.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            JsonField jf = fields[i].getAnnotation(JsonField.class);
            json.append("\"").append(jf.name()).append("\":\"")
                .append(fields[i].get(u)).append("\"");
            if (i < fields.length - 1) json.append(",");
        }

        json.append("}");
        System.out.println(json);
    }
}
