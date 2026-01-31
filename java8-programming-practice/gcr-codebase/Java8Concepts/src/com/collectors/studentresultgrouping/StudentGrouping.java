package com.collectors.studentresultgrouping;

import java.util.*;
import java.util.stream.Collectors;

public class StudentGrouping {
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student("Andrew", "A"),
                new Student("Anuj", "B"),
                new Student("Aryan", "A"),
                new Student("Tristan", "B")
        );

        Map<String, List<String>> result =
                students.stream()
                        .collect(Collectors.groupingBy(
                                Student::getGrade,
                                Collectors.mapping(Student::getName, Collectors.toList())
                        ));

        System.out.println(result);
    }
}
