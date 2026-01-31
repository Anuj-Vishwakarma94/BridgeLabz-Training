package com.interfaces.functional;

public class BackgroundJobExecution {

    private static void runJob() {

        Runnable job = () -> {
            System.out.println("Background job started...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Job interrupted");
            }
            System.out.println("Background job completed.");
        };

        Thread t = new Thread(job);
        t.start();
    }

    public static void main(String[] args) {
        runJob();
    }
}

