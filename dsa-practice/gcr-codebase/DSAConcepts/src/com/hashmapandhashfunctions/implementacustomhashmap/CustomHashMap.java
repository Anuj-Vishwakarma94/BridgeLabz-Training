package com.hashmapandhashfunctions.implementacustomhashmap;

public class CustomHashMap {

    // Node for linked list
    private static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 16; // default capacity
    private Node[] buckets;

    public CustomHashMap() {
        buckets = new Node[SIZE];
    }

    // Hash function
    private int getIndex(int key) {
        return Math.abs(key) % SIZE;
    }

    // PUT operation
    public void put(int key, int value) {
        int index = getIndex(key);
        Node head = buckets[index];

        // Update value if key exists
        while (head != null) {
            if (head.key == key) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // Insert new node at beginning
        Node newNode = new Node(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
    }

    // GET operation
    public Integer get(int key) {
        int index = getIndex(key);
        Node head = buckets[index];

        while (head != null) {
            if (head.key == key) {
                return head.value;
            }
            head = head.next;
        }
        return null; // key not found
    }

    // REMOVE operation
    public void remove(int key) {
        int index = getIndex(key);
        Node head = buckets[index];
        Node prev = null;

        while (head != null) {
            if (head.key == key) {
                if (prev == null) {
                    buckets[index] = head.next;
                } else {
                    prev.next = head.next;
                }
                return;
            }
            prev = head;
            head = head.next;
        }
    }
}
