package com.interfaces.marker.cloningprototype;

public class CloneMain {
    public static void main(String[] args) {

        try {
            Product p1 = new Product(201, "Laptop");
            Product p2 = (Product) p1.clone();

            p1.display();
            p2.display();
        } catch (Exception e) {
            System.out.println("Cloning failed.");
        }
    }
}

