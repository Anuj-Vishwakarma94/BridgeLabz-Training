package com.lamdaexpresions.schoolstudentsystem;

public class Student {
    int id;
    String name;
    int age;
    int marks;
    int rank;

    public Student(int id, String name, int age, int marks, int rank) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
        this.rank = rank;
    }

    public String toString() {
        return id + " " + name + " " + age + " " + marks + " " + rank;
    }
}
