package com.traincompanion;

import java.util.List;

public class TrainRoute {

    private Compartment head;
    private Compartment tail;

    public void addCompartment(String name, List<String> services) {
        Compartment newCompartment = new Compartment(name, services);

        if (head == null) {
            head = tail = newCompartment;
        } else {
            tail.next = newCompartment;
            newCompartment.prev = tail;
            tail = newCompartment;
        }
        System.out.println("Compartment added");
    }

    public void removeCompartment(String name) {
        Compartment temp = head;

        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {

                if (temp == head) {
                    head = temp.next;
                    if (head != null)
                        head.prev = null;
                } else if (temp == tail) {
                    tail = temp.prev;
                    tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }

                System.out.println("Compartment removed");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Compartment not found");
    }

    public void traverseForward() {
        Compartment temp = head;
        while (temp != null) {
            System.out.print(temp.name + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public void traverseBackward() {
        Compartment temp = tail;
        while (temp != null) {
            System.out.print(temp.name + " <-> ");
            temp = temp.prev;
        }
        System.out.println("NULL");
    }

    public void showAdjacent(String name) {
        Compartment temp = head;

        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {

                String prev = (temp.prev != null) ? temp.prev.name : "None";
                String next = (temp.next != null) ? temp.next.name : "None";

                System.out.println("Previous: " + prev);
                System.out.println("Current : " + temp.name);
                System.out.println("Next     : " + next);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Compartment not found");
    }

    public void searchService(String service) {
        Compartment temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.services.contains(service)) {
                System.out.println(service + " available in compartment: " + temp.name);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("Service not found in any compartment");
        }
    }
}
