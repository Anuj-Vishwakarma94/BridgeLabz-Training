package com.linkedlist.circularlinkedlist.roundrobincpuscheduling;

public class RoundRobinScheduling {
    public static void main(String[] args) {

        int timeQuantum = 3;
        RoundRobinScheduler scheduler = new RoundRobinScheduler(timeQuantum);

        // Store references for average calculation
        ProcessNode[] processes = new ProcessNode[4];

        processes[0] = new ProcessNode(1, 10, 1);
        processes[1] = new ProcessNode(2, 5, 2);
        processes[2] = new ProcessNode(3, 8, 1);
        processes[3] = new ProcessNode(4, 6, 3);

        for (ProcessNode p : processes)
            scheduler.addProcess(p.processId, p.burstTime, p.priority);

        scheduler.schedule();

        scheduler.displayAverages(processes);
    }
}