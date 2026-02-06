package com.functionalinterface.runnable;

public class FileCleanupTask implements Runnable {

    @Override
    public void run() {
        System.out.println("Cleaning temporary files");
    }
}

