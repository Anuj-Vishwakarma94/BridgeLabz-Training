package com.stackandqueue.slidingwindowmaximum;

public class DequeArray {

    private int[] elements;
    private int front;
    private int rear;

    DequeArray(int capacity) {
        elements = new int[capacity];
        front = 0;
        rear = -1;
    }

    boolean isEmpty() {
        return front > rear;
    }

    void addLast(int value) {
        elements[++rear] = value;
    }

    void removeLast() {
        rear--;
    }

    void removeFirst() {
        front++;
    }

    int peekFirst() {
        return elements[front];
    }

    int peekLast() {
        return elements[rear];
    }
}
