package com.functionalinterface.consumer;

import java.util.function.Consumer;

public class ConsumerMain {

    public static void main(String[] args) {

        Student student = new Student("Anuj", 22);
        Consumer<Student> printStudent =
                s -> System.out.println(s.getName() + " " + s.getAge());
        printStudent.accept(student);

        Employee emp = new Employee("Anuj123");
        Consumer<Employee> logLogin =
                e -> System.out.println("Employee logged in: " + e.getUsername());
        logLogin.accept(emp);

        Order order = new Order("ORD101");
        Consumer<Order> confirmOrder =
                o -> System.out.println("Order confirmed: " + o.getOrderId());
        confirmOrder.accept(order);

        Account account = new Account(5000);
        Consumer<Account> showBalance =
                a -> System.out.println("Balance: " + a.getBalance());
        showBalance.accept(account);

        Consumer<String> sendNotification =
                msg -> System.out.println("Notification sent: " + msg);
        sendNotification.accept("Payment Successful");
    }
}

