package com.interfaces.marker.cloningprototype;

public class Product implements Cloneable {

 private int id;
 private String name;

 public Product(int id, String name) {
     this.id = id;
     this.name = name;
 }

 public Object clone() throws CloneNotSupportedException {
     return super.clone();
 }

 public void display() {
     System.out.println("ID: " + id + ", Name: " + name);
 }
}

