package com.streams.students;

import java.util.*;

class Student {

    private int id;
    private String firstName;
    private int age;
    private String gender;
    private String city;
    private String department;
    private int rank;
    private List<String> contacts;

    public Student(int id, String firstName, int age, String gender, String city, String department, int rank, List<String> contacts) {

        this.id = id;
        this.firstName = firstName;
        this.age = age;
        this.gender = gender;
        this.city = city;
        this.department = department;
        this.rank = rank;
        this.contacts = contacts;
    }

    public int getId() {return id;} 
    public String getFirstName() { return firstName; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getCity() { return city; }
    public String getDepartment() { return department; }
    public int getRank() { return rank; }
    public List<String> getContacts() { return contacts; }


    @Override
    public String toString() {
        return id + " | " + firstName + " | " + age + " | " + gender + " | " + city + " | " + department + " | Rank: " + rank + " | Contacts: " + contacts;
    }
}