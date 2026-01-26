package com.reflection;

import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) { return a + b; }
    public int subtract(int a, int b) { return a - b; }
    public int multiply(int a, int b) { return a * b; }
}

public class DynamicMethodCall {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String methodName = sc.nextLine();

        MathOperations obj = new MathOperations();
        Method m = MathOperations.class.getMethod(methodName, int.class, int.class);
        System.out.println(m.invoke(obj, 10, 5));
    }
}
