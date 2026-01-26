package com.reflection;

import java.lang.reflect.Proxy;

interface Greeting {
    void sayHello();
}

class GreetingImpl implements Greeting {
    public void sayHello() {
        System.out.println("Hello World");
    }
}

public class LoggingProxy {
    public static void main(String[] args) {
        Greeting g = new GreetingImpl();

        Greeting proxy = (Greeting) Proxy.newProxyInstance(
            g.getClass().getClassLoader(),
            g.getClass().getInterfaces(),
            (obj, method, params) -> {
                System.out.println("Calling method: " + method.getName());
                return method.invoke(g, params);
            }
        );

        proxy.sayHello();
    }
}
