package com.ambulanceroute;
public class AmbulanceRoute {
    private Unit head = null;

    public void addUnit(String name, boolean available) {
        Unit newUnit = new Unit(name, available);

        if (head == null) {
            head = newUnit;
            newUnit.next = head;
            return;
        }

        Unit temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = newUnit;
        newUnit.next = head;
    }

    public void findAvailableUnit(String startUnit) {
        if (head == null) {
            System.out.println("No units present");
            return;
        }

        Unit temp = head;
        do {
            if (temp.name.equals(startUnit)) {
                break;
            }
            temp = temp.next;
        } while (temp != head);

        if (!temp.name.equals(startUnit)) {
            System.out.println("Starting unit not found");
            return;
        }

        Unit current = temp;
        do {
            if (current.available) {
                System.out.println("Patient redirected to " + current.name);
                return;
            }
            current = current.next;
        } while (current != temp);

        System.out.println("No available unit found");
    }

    public void removeUnit(String name) {
        if (head == null) return;

        Unit curr = head;
        Unit prev = null;

        do {
            if (curr.name.equals(name)) {
                if (curr == head && curr.next == head) {
                    head = null;
                } else {
                    if (curr == head) {
                        head = head.next;
                    }
                    if (prev != null) {
                        prev.next = curr.next;
                    }
                    Unit last = head;
                    while (last.next != curr) {
                        last = last.next;
                    }
                    last.next = head;
                }
                System.out.println(name + " removed for maintenance");
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);

        System.out.println("Unit not found");
    }

    public void displayUnits() {
        if (head == null) {
            System.out.println("No units to display");
            return;
        }

        Unit temp = head;
        do {
            System.out.println(temp.name + " Available: " + temp.available);
            temp = temp.next;
        } while (temp != head);
    }
}
