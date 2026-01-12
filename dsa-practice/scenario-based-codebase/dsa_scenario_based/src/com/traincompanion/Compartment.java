package com.traincompanion;

import java.util.List;

public class Compartment {

    String name;
    List<String> services;
    Compartment prev;
    Compartment next;

    public Compartment(String name, List<String> services) {
        this.name = name;
        this.services = services;
        this.prev = null;
        this.next = null;
    }
}
