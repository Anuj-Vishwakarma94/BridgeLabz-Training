package com.functionalinterface.function;

import java.util.function.Function;

public class FunctionMain {

    public static void main(String[] args) {

        Student student = new Student(85);
        Function<Student, String> gradeFunction =
                s -> s.getMarks() >= 80 ? "A" : s.getMarks() >= 60 ? "B" : "C";
        System.out.println(gradeFunction.apply(student));

        Employee emp = new Employee(30000);
        Function<Employee, Double> annualSalary =
                e -> e.getMonthlySalary() * 12;
        System.out.println(annualSalary.apply(emp));

        Product product = new Product(1000);
        Function<Product, Double> discountedPrice =
                p -> p.getPrice() * 0.9;
        System.out.println(discountedPrice.apply(product));

        Function<String, String> upperName =
                String::toUpperCase;
        System.out.println(upperName.apply("anuj"));

        Function<Double, Double> celsiusToFahrenheit =
                c -> (c * 9 / 5) + 32;
        System.out.println(celsiusToFahrenheit.apply(25.0));
    }
}

