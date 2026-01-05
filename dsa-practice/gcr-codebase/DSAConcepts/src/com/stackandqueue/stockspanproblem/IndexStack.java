package com.stackandqueue.stockspanproblem;

public class IndexStack {

    private int[] elements;
    private int top;

    IndexStack(int capacity) {
        elements = new int[capacity];
        top = -1;
    }

    boolean isEmpty() {
        return top == -1;
    }

    void push(int value) {
        elements[++top] = value;
    }

    int pop() {
        return elements[top--];
    }

    int peek() {
        return elements[top];
    }
}
