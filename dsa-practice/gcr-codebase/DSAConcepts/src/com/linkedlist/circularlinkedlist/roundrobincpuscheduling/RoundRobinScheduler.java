package com.linkedlist.circularlinkedlist.roundrobincpuscheduling;

public class RoundRobinScheduler {
    private ProcessNode head;
    private int timeQuantum;
    private int currentTime = 0;
    private int processCount = 0;

    public RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    public void addProcess(int id, int burst, int priority) {
        ProcessNode newNode = new ProcessNode(id, burst, priority);

        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            ProcessNode temp = head;
            while (temp.next != head)
                temp = temp.next;

            temp.next = newNode;
            newNode.next = head;
        }
        processCount++;
    }

    public void schedule() {
        if (head == null) {
            System.out.println("No processes to schedule");
            return;
        }

        ProcessNode current = head;
        ProcessNode prev = null;

        System.out.println("\n--- Round Robin Scheduling Started ---");

        while (processCount > 0) {

            displayQueue();

            if (current.remainingTime > 0) {
                int execTime = Math.min(current.remainingTime, timeQuantum);
                current.remainingTime -= execTime;
                currentTime += execTime;
            }

            // If process completed
            if (current.remainingTime == 0) {
                current.completionTime = currentTime;
                current.turnaroundTime = current.completionTime;
                current.waitingTime = current.turnaroundTime - current.burstTime;

                System.out.println("Process " + current.processId + " completed");

                // Remove from circular list
                if (current == head && current.next == head) {
                    head = null;
                } else {
                    if (current == head)
                        head = head.next;

                    prev.next = current.next;
                }

                processCount--;
                current = (prev != null) ? prev.next : head;
            } else {
                prev = current;
                current = current.next;
            }
        }

        System.out.println("\n--- Scheduling Completed ---");
    }

    private void displayQueue() {
        if (head == null)
            return;

        ProcessNode temp = head;
        System.out.print("Queue: ");
        do {
            System.out.print(
                "[P" + temp.processId +
                " RT=" + temp.remainingTime + "] "
            );
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public void displayAverages(ProcessNode[] processes) {
        double totalWT = 0, totalTAT = 0;

        for (ProcessNode p : processes) {
            totalWT += p.waitingTime;
            totalTAT += p.turnaroundTime;
        }

        System.out.println("\nAverage Waiting Time = " + (totalWT / processes.length));
        System.out.println("Average Turnaround Time = " + (totalTAT / processes.length));
    }
}