package com.parceltracker;

public class ParcelChain {

    private Stage head;

    public ParcelChain() {
        head = null;
    }

    public void addStage(String name) {
        Stage newStage = new Stage(name);

        if (head == null) {
            head = newStage;
            return;
        }

        Stage temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStage;
    }

    public void addAfter(String existingStage, String newStageName) {
        Stage temp = head;

        while (temp != null) {
            if (temp.name.equalsIgnoreCase(existingStage)) {
                Stage newStage = new Stage(newStageName);
                newStage.next = temp.next;
                temp.next = newStage;
                return;
            }
            temp = temp.next;
        }

        System.out.println("Stage not found");
    }

    public void trackParcel() {
        if (head == null) {
            System.out.println("Parcel lost or not initialized");
            return;
        }

        Stage temp = head;
        while (temp != null) {
            System.out.print(temp.name);
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    public void simulateLoss() {
        if (head == null || head.next == null) {
            System.out.println("Cannot simulate loss");
            return;
        }

        head.next.next = null;
        System.out.println("Parcel lost after second stage");
    }
}
