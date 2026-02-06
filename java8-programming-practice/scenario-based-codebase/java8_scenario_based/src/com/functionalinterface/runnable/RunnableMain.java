package com.functionalinterface.runnable;

public class RunnableMain {

    public static void main(String[] args) {

        Runnable backgroundTask = new BackgroundTask();
        new Thread(backgroundTask).start();

        Runnable cleanupTask = new FileCleanupTask();
        new Thread(cleanupTask).start();

        Runnable messageTask =
                () -> System.out.println("Running in separate thread");
        new Thread(messageTask).start();
    }
}

