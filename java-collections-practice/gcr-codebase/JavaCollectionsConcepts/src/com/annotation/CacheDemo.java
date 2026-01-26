package com.annotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

class ExpensiveService {
    @CacheResult
    public int compute(int x) {
        try { Thread.sleep(1000); } catch (Exception e) {}
        return x * x;
    }
}

public class CacheDemo {
    static Map<Integer, Object> cache = new HashMap<>();

    public static void main(String[] args) throws Exception {
        ExpensiveService s = new ExpensiveService();
        Method m = ExpensiveService.class.getMethod("compute", int.class);

        int input = 5;

        if (cache.containsKey(input)) {
            System.out.println(cache.get(input));
        } else {
            Object result = m.invoke(s, input);
            cache.put(input, result);
            System.out.println(result);
        }
    }
}
