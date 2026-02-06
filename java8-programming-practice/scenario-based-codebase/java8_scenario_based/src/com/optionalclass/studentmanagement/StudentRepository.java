package com.optionalclass.studentmanagement;

import java.util.*;

public class StudentRepository {

    private List<Student> students = new ArrayList<>();

    public StudentRepository() {
        students.add(new Student(1, "Andrew", "andrew@gmail.com", null, "Delhi", "Rocky"));
        students.add(new Student(2, "Anuj", null, "9999999999", null, null));
    }

    public Optional<Student> findById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst();
    }
}

