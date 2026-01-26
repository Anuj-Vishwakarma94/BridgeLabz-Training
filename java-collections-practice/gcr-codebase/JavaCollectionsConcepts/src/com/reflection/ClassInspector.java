package com.reflection;

import java.lang.reflect.*;
import java.util.Scanner;

public class ClassInspector {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String className = sc.nextLine();

        Class<?> cls = Class.forName(className);

        for (Method m : cls.getDeclaredMethods())
            System.out.println("Method: " + m.getName());

        for (Field f : cls.getDeclaredFields())
            System.out.println("Field: " + f.getName());

        for (Constructor<?> c : cls.getDeclaredConstructors())
            System.out.println("Constructor: " + c.getName());
    }
}
