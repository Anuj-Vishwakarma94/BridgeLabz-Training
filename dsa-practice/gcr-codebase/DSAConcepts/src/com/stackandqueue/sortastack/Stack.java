package com.stackandqueue.sortastack;

public class Stack {

    private int[] elements;
    private int top;

    Stack(int capacity) {
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

    int peek() {
        return isEmpty() ? -1 : elements[top];
    }
}
