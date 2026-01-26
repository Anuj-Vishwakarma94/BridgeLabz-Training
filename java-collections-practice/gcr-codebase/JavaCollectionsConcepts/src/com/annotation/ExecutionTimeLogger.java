package com.annotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

class PerformanceTest {
    @LogExecutionTime
    public void fast() {
        for (int i = 0; i < 100000; i++);
    }

    @LogExecutionTime
    public void slow() {
        for (int i = 0; i < 1000000; i++);
    }
}

public class ExecutionTimeLogger {
    public static void main(String[] args) throws Exception {
        PerformanceTest p = new PerformanceTest();

        for (Method m : PerformanceTest.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.nanoTime();
                m.invoke(p);
                long end = System.nanoTime();
                System.out.println(m.getName() + " " + (end - start));
            }
        }
    }
}
