package com.multithreading.restrauntorderprocessingsystem;
class Chef extends Thread {
    private String dish;
    private int totalTime;

    Chef(String chefName, String dish, int totalTime) {
        super(chefName);
        this.dish = dish;
        this.totalTime = totalTime;
    }

    public void run() {
        System.out.println(getName() + " started preparing " + dish);

        try {
            for (int i = 25; i <= 100; i += 25) {
                Thread.sleep(totalTime / 4);
                System.out.println(getName() + " preparing " + dish + ": " + i + "% complete");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
