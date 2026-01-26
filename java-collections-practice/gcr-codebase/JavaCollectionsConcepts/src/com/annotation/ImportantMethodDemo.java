package com.annotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

class ServiceA {
    @ImportantMethod
    public void process() {}

    @ImportantMethod(level = "LOW")
    public void helper() {}

    public void normal() {}
}

public class ImportantMethodDemo {
    public static void main(String[] args) {
        for (Method m : ServiceA.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod im = m.getAnnotation(ImportantMethod.class);
                System.out.println(m.getName() + " " + im.level());
            }
        }
    }
}
