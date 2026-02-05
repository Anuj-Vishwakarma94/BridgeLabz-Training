package com.multithreading.threadstatemonitoringsystem;
class TaskRunner extends Thread {

    TaskRunner(String name) {
        super(name);
    }

    public void run() {
        long sum = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sum += i;
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrupted");
        }
    }
}
