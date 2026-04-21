package com.learning.multithreading;

class WorkerThread implements Runnable {
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("Worker done");
        } catch(InterruptedException exc) {
            Thread.currentThread().interrupt();
        }
    }
}
public class RaceObservation {
     static void main() throws InterruptedException {
        Thread t = new Thread(new WorkerThread());
        t.start();
        while(t.isAlive()) {
            System.out.println("Waiting...");
            Thread.sleep(500);
        }
        t.join();
        System.out.println("Main done");
    }
}
