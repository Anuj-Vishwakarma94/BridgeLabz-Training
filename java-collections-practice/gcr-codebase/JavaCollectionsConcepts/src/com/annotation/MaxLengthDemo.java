package com.annotation;

import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(5)
    String username;

    User(String username) throws Exception {
        Field f = User.class.getDeclaredField("username");
        MaxLength ml = f.getAnnotation(MaxLength.class);
        if (username.length() > ml.value())
            throw new IllegalArgumentException("Length exceeded");
        this.username = username;
    }
}

public class MaxLengthDemo {
    public static void main(String[] args) throws Exception {
        new User("Anuj");
    }
}
