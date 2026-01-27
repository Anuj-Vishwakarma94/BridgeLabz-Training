package com.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

class User {
    public String name;
    public int age;

    User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class ListToJsonArray {
    public static void main(String[] args) throws Exception {
        List<User> users = List.of(
                new User("A", 20),
                new User("B", 30)
        );

        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(users));
    }
}
