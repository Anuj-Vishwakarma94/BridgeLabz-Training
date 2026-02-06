package com.lamdaexpresions.schoolstudentsystem;

import java.util.*;

public class MainApp {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        students.add(new Student(1, "Anuj", 19, 75, 2));
        students.add(new Student(2, "Andrew", 17, 35, 5));
        students.add(new Student(3, "Tristan", 20, 88, 1));
        students.add(new Student(4, "Selena", 18, 60, 3));

        WelcomeMessage wm = name -> System.out.println("Welcome " + name);
        wm.show("Ravi");

        PassFailCheck pf = marks -> marks >= 40;
        System.out.println("Result: " + (pf.check(75) ? "Pass" : "Fail"));

        StudentSort.sortByName(students);
        System.out.println("\nSorted by Name:");
        students.forEach(System.out::println);

        StudentSort.sortByRank(students);
        System.out.println("\nSorted by Rank:");
        students.forEach(System.out::println);

        System.out.println("\nStudents age > 18:");
        students.stream()
                .filter(s -> s.age > 18)
                .forEach(System.out::println);
    }
}
