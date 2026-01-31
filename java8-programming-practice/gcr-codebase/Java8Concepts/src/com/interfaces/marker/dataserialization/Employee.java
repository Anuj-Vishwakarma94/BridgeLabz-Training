package com.interfaces.marker.dataserialization;

import java.io.*;

public class Employee implements Serializable {

 private int id;
 private String name;

 public Employee(int id, String name) {
     this.id = id;
     this.name = name;
 }

 public void display() {
     System.out.println("ID: " + id + ", Name: " + name);
 }
}

