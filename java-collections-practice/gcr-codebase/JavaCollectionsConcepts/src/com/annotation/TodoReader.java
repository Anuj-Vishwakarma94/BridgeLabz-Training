package com.annotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class Project {
    @Todo(task = "Add login", assignedTo = "Anuj", priority = "HIGH")
    public void login() {}

    @Todo(task = "Improve UI", assignedTo = "Aryan")
    public void ui() {}
}

public class TodoReader {
    public static void main(String[] args) {
        for (Method m : Project.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Todo.class)) {
                Todo t = m.getAnnotation(Todo.class);
                System.out.println(
                    m.getName() + " " +
                    t.task() + " " +
                    t.assignedTo() + " " +
                    t.priority()
                );
            }
        }
    }
}
