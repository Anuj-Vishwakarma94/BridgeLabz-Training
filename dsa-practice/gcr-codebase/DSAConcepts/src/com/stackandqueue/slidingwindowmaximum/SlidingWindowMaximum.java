package com.stackandqueue.slidingwindowmaximum;

class SlidingWindowMaximum {

    static void printMaximumInEachWindow(int[] array, int windowSize) {

        DequeArray deque = new DequeArray(array.length);

        for (int currentIndex = 0; currentIndex < array.length; currentIndex++) {

            // Remove indices outside current window
            if (!deque.isEmpty() && deque.peekFirst() <= currentIndex - windowSize) {
                deque.removeFirst();
            }

            // Remove smaller elements from back
            while (!deque.isEmpty() && array[deque.peekLast()] <= array[currentIndex]) {
                deque.removeLast();
            }

            deque.addLast(currentIndex);

            // Print max for valid windows
            if (currentIndex >= windowSize - 1) {
                System.out.print(array[deque.peekFirst()] + " ");
            }
        }
    }

    public static void main(String[] args) {

        int[] array = {1, 3, -1, -3, 5, 3, 6, 7};
        int windowSize = 3;

        printMaximumInEachWindow(array, windowSize);
    }
}
