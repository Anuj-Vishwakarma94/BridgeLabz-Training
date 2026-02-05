package com.multithreading.threadstatemonitoringsystem;
class ThreadStateMonitoringSystem {
    public static void main(String[] args) {

        TaskRunner t1 = new TaskRunner("Task-1");
        TaskRunner t2 = new TaskRunner("Task-2");

        StateMonitor monitor = new StateMonitor(t1, t2);

        monitor.start();

        t1.start();
        t2.start();
    }
}
