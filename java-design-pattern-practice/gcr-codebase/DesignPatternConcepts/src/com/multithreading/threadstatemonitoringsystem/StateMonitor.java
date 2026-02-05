package com.multithreading.threadstatemonitoringsystem;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class StateMonitor extends Thread {
    private TaskRunner t1;
    private TaskRunner t2;
    private Map<String, Set<Thread.State>> stateHistory = new HashMap<>();

    StateMonitor(TaskRunner t1, TaskRunner t2) {
        this.t1 = t1;
        this.t2 = t2;
        stateHistory.put(t1.getName(), new HashSet<>());
        stateHistory.put(t2.getName(), new HashSet<>());
    }

    public void run() {
        while (true) {
            monitorThread(t1);
            monitorThread(t2);

            if (t1.getState() == Thread.State.TERMINATED &&
                t2.getState() == Thread.State.TERMINATED) {
                break;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Monitor interrupted");
            }
        }

        printSummary();
    }

    private void monitorThread(Thread t) {
        Thread.State state = t.getState();
        stateHistory.get(t.getName()).add(state);
        System.out.println("[Monitor] " + t.getName() +
                " is in " + state +
                " state at " + LocalTime.now());
    }

    private void printSummary() {
        System.out.println("\nSummary:");
        for (String name : stateHistory.keySet()) {
            System.out.println(name + " went through " +
                    stateHistory.get(name).size() + " states");
        }
    }
}
