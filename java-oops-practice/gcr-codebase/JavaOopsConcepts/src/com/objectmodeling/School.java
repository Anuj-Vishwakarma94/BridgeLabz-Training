package com.objectmodeling;
import java.util.ArrayList;
import java.util.Scanner;

public class School {

    String schoolname;
    ArrayList<Student> studentlist = new ArrayList<>();

    School(String schoolname) {
        this.schoolname = schoolname;
    }

    void addStudent(Student student) {
        studentlist.add(student);
    }

    void showStudents() {
        System.out.println("Students in " + schoolname + ":");
        for (Student student : studentlist) {
            System.out.println(student.studentname);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        School school = new School("Green Valley School");

        Student student1 = new Student("Aryan");
        Student student2 = new Student("Neha");

        Course math = new Course("Mathematics");
        Course science = new Course("Science");

        school.addStudent(student1);
        school.addStudent(student2);

        student1.enrollCourse(math);
        student1.enrollCourse(science);

        student2.enrollCourse(science);

        school.showStudents();

        student1.showCourses();
        student2.showCourses();

        math.showStudents();
        science.showStudents();
        sc.close();
    }
}
