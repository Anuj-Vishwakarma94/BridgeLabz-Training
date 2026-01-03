package com.linkedlist.circularlinkedlist.taskscheduler;

public class CircularTaskScheduler {
    public static void main(String[] args) {

        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addAtEnd(1, "Write Code", 1, "2026-01-10");
        scheduler.addAtEnd(2, "Encoding", 2, "2026-01-12");
        scheduler.addAtBeginning(3, "Fix Bugs", 1, "2026-01-08");
        scheduler.addAtPosition(2, 4, "Testing", 3, "2026-01-11");

        scheduler.displayAllTasks();

        System.out.println("\n--- Current Task ---");
        scheduler.viewCurrentTask();

        System.out.println("\n--- Move to Next Task ---");
        scheduler.moveToNextTask();
        scheduler.viewCurrentTask();

        System.out.println("\n--- Search by Priority (1) ---");
        scheduler.searchByPriority(1);

        System.out.println("\n--- Remove Task (ID = 2) ---");
        scheduler.removeByTaskId(2);
        scheduler.displayAllTasks();
    }
}