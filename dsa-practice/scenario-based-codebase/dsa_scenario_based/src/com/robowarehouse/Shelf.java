package com.robowarehouse;

class Shelf {
    private Package[] packages;
    private int size;
    private final int capacity;

    public Shelf(int capacity) {
        this.capacity = capacity;
        packages = new Package[capacity];
        size = 0;
    }

    public boolean addPackage(Package pkg) {
        if (size == capacity) {
            return false;
        }

        int i = size - 1;
        while (i >= 0 && packages[i].weight > pkg.weight) {
            packages[i + 1] = packages[i];
            i--;
        }

        packages[i + 1] = pkg;
        size++;
        return true;
    }

    public void displayShelf() {
        if (size == 0) {
            System.out.println("Shelf is empty.");
            return;
        }

        System.out.println("\nShelf status (sorted by weight):");
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + ". " + packages[i]);
        }
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
