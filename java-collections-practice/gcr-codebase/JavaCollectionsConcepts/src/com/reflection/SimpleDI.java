package com.reflection;

import java.lang.reflect.Field;

@interface Inject {}

class Service {
    void work() {
        System.out.println("Service Working");
    }
}

class Client {
    @Inject
    Service service;
}

public class SimpleDI {
    public static void main(String[] args) throws Exception {
        Client c = new Client();

        for (Field f : Client.class.getDeclaredFields()) {
            if (f.isAnnotationPresent(Inject.class)) {
                f.setAccessible(true);
                f.set(c, f.getType().getDeclaredConstructor().newInstance());
            }
        }

        c.service.work();
    }
}
