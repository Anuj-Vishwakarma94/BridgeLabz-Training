package com.optionalclass.studentmanagement;

import java.util.Optional;

public class Student {

    private int id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String nickname;

    public Student(int id, String name, String email, String phone, String address, String nickname) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.nickname = nickname;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }

    public Optional<String> getPhone() {
        return Optional.ofNullable(phone);
    }

    public Optional<String> getAddress() {
        return Optional.ofNullable(address);
    }

    public Optional<String> getNickname() {
        return Optional.ofNullable(nickname);
    }
}

