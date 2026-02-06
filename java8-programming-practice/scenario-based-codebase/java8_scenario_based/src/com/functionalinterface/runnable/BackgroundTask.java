package com.functionalinterface.runnable;

public class BackgroundTask implements Runnable {

    @Override
    public void run() {
        System.out.println("Background task running");
    }
}
