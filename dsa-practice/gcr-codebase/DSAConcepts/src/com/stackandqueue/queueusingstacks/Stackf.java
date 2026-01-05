package com.stackandqueue.queueusingstacks;

public class Stackf {

    private int[] elements;
    private int top;

    Stackf(int capacity) {
        elements = new int[capacity];
        top = -1;
    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFull() {
        return top == elements.length - 1;
    }

    void push(int value) {
        if (!isFull()) {
            elements[++top] = value;
        }
    }

    int pop() {
        return isEmpty() ? -1 : elements[top--];
    }
}
