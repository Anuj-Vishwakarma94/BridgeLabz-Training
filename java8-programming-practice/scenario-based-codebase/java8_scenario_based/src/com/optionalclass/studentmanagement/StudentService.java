package com.optionalclass.studentmanagement;

public class StudentService {

    public static void main(String[] args) {

        StudentRepository repo = new StudentRepository();

        Student student = repo.findById(1)
                .orElseThrow(() -> new RuntimeException("Student not available"));

        String email = student.getEmail()
                .orElse("Email not provided");

        String phone = student.getPhone()
                .orElse("0000000000");

        String address = student.getAddress()
                .orElse("Address not available");

        String displayName = student.getNickname()
                .orElse(student.getName());

        System.out.println(email);
        System.out.println(phone);
        System.out.println(address);
        System.out.println(displayName);


        repo.findById(5)
                .ifPresentOrElse(
                        s -> System.out.println(s.getName()),
                        () -> System.out.println("Student not available")
                );
    }
}

