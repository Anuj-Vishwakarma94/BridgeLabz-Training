package com.reflection;

class Student {
    public Student() {
        System.out.println("Student Created");
    }
}

public class DynamicObjectCreation {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("com.reflection.Student");
        cls.getDeclaredConstructor().newInstance();
    }
}
