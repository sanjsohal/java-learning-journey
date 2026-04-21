package com.learning.multithreading;

public class InterruptedDemo {
    public static void main(String...args) throws InterruptedException {
        Thread worker = new Thread(()-> {
            try {
                System.out.println("Thread slept for 10 seconds");
                Thread.sleep(10000);
                System.out.println("I woke up naturally");
            } catch(InterruptedException ex) {
                System.out.println("I was interrupted while sleeping");
                Thread.currentThread().interrupt();
            }
        });
        worker.start();
        Thread.sleep(2000);
        System.out.println("Main: Enough sleeping! Wake up.");
        worker.interrupt();
    }
}
