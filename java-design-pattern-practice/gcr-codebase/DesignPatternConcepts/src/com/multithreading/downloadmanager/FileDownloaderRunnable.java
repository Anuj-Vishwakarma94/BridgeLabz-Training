package com.multithreading.downloadmanager;
import java.util.Random;

class FileDownloaderRunnable implements Runnable {
    private String fileName;

    FileDownloaderRunnable(String fileName) {
        this.fileName = fileName;
    }

    public void run() {
        Random random = new Random();
        for (int i = 0; i <= 100; i += 10) {
            System.out.println("[" + Thread.currentThread().getName() + "] Downloading " + fileName + ": " + i + "%");
            try {
                Thread.sleep(200 + random.nextInt(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new FileDownloaderRunnable("Document.pdf"));
        Thread t2 = new Thread(new FileDownloaderRunnable("Image.jpg"));
        Thread t3 = new Thread(new FileDownloaderRunnable("Video.mp4"));

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("All downloads complete!");
    }
}
