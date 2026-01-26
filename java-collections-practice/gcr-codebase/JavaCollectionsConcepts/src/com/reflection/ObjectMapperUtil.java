package com.reflection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

class User {
    String name;
    int age;
}

public class ObjectMapperUtil {
    public static <T> T toObject(Class<T> cls, Map<String, Object> map) throws Exception {
        T obj = cls.getDeclaredConstructor().newInstance();
        for (String key : map.keySet()) {
            Field f = cls.getDeclaredField(key);
            f.setAccessible(true);
            f.set(obj, map.get(key));
        }
        return obj;
    }

    public static void main(String[] args) throws Exception {
        Map<String, Object> data = new HashMap<>();
        data.put("name", "Anuj");
        data.put("age", 22);

        User u = toObject(User.class, data);
        System.out.println(u.name + " " + u.age);
    }
}
