package com.addressbooksystem;
public class Contact {

    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private Address address;

    public Contact(String firstName, String lastName,
                   String phone, String email, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getPhone() {
        return phone;
    }

    public Address getAddress() {
        return address;
    }

    public void update(String phone, String email, Address address) {
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public void display() {
        System.out.println("Name   : " + getFullName());
        System.out.println("Phone  : " + phone);
        System.out.println("Email  : " + email);
        System.out.println("Address: " + address);
        System.out.println("----------------------------");
    }
}
