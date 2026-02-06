package com.functionalinterface.predicate;

import java.util.function.Predicate;

public class PredicateMain {

    public static void main(String[] args) {

        Student student = new Student(80);
        Predicate<Student> examEligible = s -> s.getAttendance() >= 75;
        System.out.println(examEligible.test(student));

        Employee emp = new Employee(35000);
        Predicate<Employee> highSalary = e -> e.getSalary() > 30000;
        System.out.println(highSalary.test(emp));

        double balance = 10000;
        double withdrawAmount = 6000;
        Predicate<Double> validWithdraw = amt -> amt <= balance;
        System.out.println(validWithdraw.test(withdrawAmount));

        double orderAmount = 700;
        Predicate<Double> freeDelivery = amt -> amt >= 500;
        System.out.println(freeDelivery.test(orderAmount));

        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println(isEven.test(10));
    }
}
