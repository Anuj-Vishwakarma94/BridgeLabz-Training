package com.multithreading.printshopjobscheduler;
class PrintShopScheduler {
    public static void main(String[] args) throws InterruptedException {

        long startTime = System.currentTimeMillis();

        Thread t1 = new Thread(new PrintJob("Job1", 10, 5), "Job1");
        Thread t2 = new Thread(new PrintJob("Job2", 5, 8), "Job2");
        Thread t3 = new Thread(new PrintJob("Job3", 15, 3), "Job3");
        Thread t4 = new Thread(new PrintJob("Job4", 8, 6), "Job4");
        Thread t5 = new Thread(new PrintJob("Job5", 12, 7), "Job5");

        t1.setPriority(5);
        t2.setPriority(8);
        t3.setPriority(3);
        t4.setPriority(6);
        t5.setPriority(7);

        System.out.println("Starting print jobs...");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();

        long endTime = System.currentTimeMillis();

        System.out.println("All jobs completed in " + (endTime - startTime) + "ms");
    }
}
