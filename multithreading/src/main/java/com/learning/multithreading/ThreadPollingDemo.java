package com.learning.multithreading;
public class ThreadPollingDemo {

    public static void main(String[] args) throws InterruptedException {

        Thread worker = new Thread(() -> {
            try {
                Thread.sleep(2000); // Simulate work
                System.out.println("Worker done");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        worker.start();

        // Polling loop — checks status repeatedly
        while (worker.isAlive()) {
            System.out.println("Waiting...");
            Thread.sleep(400); // Small pause to avoid busy-wait
        }

        // join() after the loop — is it necessary?
        worker.join();

        System.out.println("Main done");
    }
}
