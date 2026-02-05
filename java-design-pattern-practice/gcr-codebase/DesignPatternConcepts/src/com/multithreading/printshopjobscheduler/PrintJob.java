package com.multithreading.printshopjobscheduler;
class PrintJob implements Runnable {
    private String jobName;
    private int pages;
    private int priority;

    PrintJob(String jobName, int pages, int priority) {
        this.jobName = jobName;
        this.pages = pages;
        this.priority = priority;
    }

    public void run() {
        String level;
        if (priority >= 7) {
            level = "High Priority";
        } else if (priority >= 5) {
            level = "Medium Priority";
        } else {
            level = "Low Priority";
        }

        for (int i = 1; i <= pages; i++) {
            System.out.println("[" + level + "] Printing " + jobName + " - Page " + i + " of " + pages);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(jobName + " interrupted");
            }
        }
    }
}
