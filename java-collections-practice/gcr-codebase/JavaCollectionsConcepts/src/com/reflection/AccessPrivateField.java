package com.reflection;

import java.lang.reflect.Field;

class Person {
    private int age = 20;
}

public class AccessPrivateField {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
        Field f = Person.class.getDeclaredField("age");
        f.setAccessible(true);
        f.set(p, 25);
        System.out.println(f.get(p));
    }
}
