package com.stackandqueue.queueusingstacks;

class QueueUsingTwoStacks {

    private Stackf enqueueStack;
    private Stackf dequeueStack;

    QueueUsingTwoStacks(int capacity) {
        enqueueStack = new Stackf(capacity);
        dequeueStack = new Stackf(capacity);
    }

    // Insert element into queue
    void enqueue(int value) {
        enqueueStack.push(value);
    }

    // Remove element from queue
    int dequeue() {

        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }
        return dequeueStack.pop();
    }

    public static void main(String[] args) {

        QueueUsingTwoStacks queue = new QueueUsingTwoStacks(10);

        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue()); 
        System.out.println(queue.dequeue()); 
    }
}
