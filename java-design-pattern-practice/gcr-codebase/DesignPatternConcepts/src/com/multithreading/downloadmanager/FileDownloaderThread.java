package com.multithreading.downloadmanager;
import java.util.Random;

class FileDownloaderThread extends Thread {
    private String fileName;

    FileDownloaderThread(String fileName) {
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
        FileDownloaderThread t1 = new FileDownloaderThread("Document.pdf");
        FileDownloaderThread t2 = new FileDownloaderThread("Image.jpg");
        FileDownloaderThread t3 = new FileDownloaderThread("Video.mp4");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("All downloads complete!");
    }
}
