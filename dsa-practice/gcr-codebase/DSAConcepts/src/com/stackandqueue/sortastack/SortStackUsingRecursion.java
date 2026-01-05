package com.stackandqueue.sortastack;

class SortStackUsingRecursion {

    // Sorts the entire stack
    static void sortStack(Stack stack) {

        if (!stack.isEmpty()) {
            int removedElement = stack.pop();
            sortStack(stack);
            insertInSortedOrder(stack, removedElement);
        }
    }

    // Inserts an element in sorted position
    private static void insertInSortedOrder(Stack stack, int value) {

        if (stack.isEmpty() || stack.peek() <= value) {
            stack.push(value);
            return;
        }

        int temp = stack.pop();
        insertInSortedOrder(stack, value);
        stack.push(temp);
    }

    public static void main(String[] args) {

        Stack stack = new Stack(10);
        stack.push(30);
        stack.push(10);
        stack.push(20);
        stack.push(5);

        sortStack(stack);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
