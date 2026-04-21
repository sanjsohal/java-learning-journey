package com.learning.multithreading;

public class InterruptDemo {

     static void main() throws InterruptedException {
        Thread worker = new Thread(() -> {
            System.out.println("Worker: started");

            for (int i = 1; i <= 10; i++) {
                System.out.println("Worker: processing item " + i);
                try {
                    Thread.sleep(1000); // simulating work
                } catch (InterruptedException e) {
                    System.out.println("Worker: interrupted while sleeping!");
                    System.out.println("Worker: flag after catch = "
                            + Thread.currentThread().isInterrupted()); // false — cleared!
                    return; // stops the thread
                }
            }
        });

        worker.start();
        Thread.sleep(3000);         // let worker process a few items
        System.out.println("Main: calling interrupt!");
        worker.interrupt();         // signal the worker to stop
    }
}
