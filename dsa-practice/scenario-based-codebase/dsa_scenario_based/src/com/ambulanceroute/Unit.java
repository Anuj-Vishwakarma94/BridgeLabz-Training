package com.ambulanceroute;
public class Unit {
    String name;
    boolean available;
    Unit next;

    public Unit(String name, boolean available) {
        this.name = name;
        this.available = available;
        this.next = null;
    }
}
