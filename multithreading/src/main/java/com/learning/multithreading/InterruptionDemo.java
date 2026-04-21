package com.learning.multithreading;

public class InterruptionDemo {
    public static void doWork() throws InterruptedException{
        System.out.println("Work started");
        try {
            Thread.sleep(1000);
            System.out.println("Work Done");
        } catch(InterruptedException exc) {
            System.out.println("Work interrupted");
            Thread.currentThread().interrupt();
        }
    }
    public static void main(String...args) throws InterruptedException{
        Thread worker = new Thread(()-> {
           while(!Thread.currentThread().isInterrupted()) {
               try {
                   doWork();
               } catch(InterruptedException exc) {
                   System.out.println("Loop detected interruption, exiting....");
                   Thread.currentThread().interrupt();
                   break;
               }
            }
           System.out.println("Exited Loop cleanly. Shutting down.");
        });
        worker.start();
        Thread.sleep(3500);
        System.out.println("Interrupting worker");
        worker.interrupt();
    }
}
