package com.functionalinterface.comparator;

import java.util.Comparator;

public class ComparatorMain {

    public static void main(String[] args) {

        Student s1 = new Student(1);
        Student s2 = new Student(5);
        Comparator<Student> rankComparator =
                Comparator.comparingInt(Student::getRank);
        System.out.println(rankComparator.compare(s1, s2));

        Employee e1 = new Employee(30000);
        Employee e2 = new Employee(50000);
        Comparator<Employee> salaryComparator =
                Comparator.comparingDouble(Employee::getSalary);
        System.out.println(salaryComparator.compare(e1, e2));

        Product p1 = new Product(1000);
        Product p2 = new Product(800);
        Comparator<Product> priceComparator =
                Comparator.comparingDouble(Product::getPrice);
        System.out.println(priceComparator.compare(p1, p2));

        Comparator<String> lengthComparator =
                Comparator.comparingInt(String::length);
        System.out.println(lengthComparator.compare("Java", "Streams"));

        BankAccount b1 = new BankAccount(2000);
        BankAccount b2 = new BankAccount(5000);
        Comparator<BankAccount> balanceComparator =
                Comparator.comparingDouble(BankAccount::getBalance);
        System.out.println(balanceComparator.compare(b1, b2));
    }
}

