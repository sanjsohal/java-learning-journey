package com.learning.multithreading;

public class PrintOneToFive {
    public static void main(String...args) throws InterruptedException {
        Thread t = new Thread(() -> {
           for(int i = 0; i<5; i++) {
               System.out.println(i);
               try {
                   Thread.sleep(500);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
        });
        System.out.println("Thread alive or not before starting: "+t.isAlive());
        t.start();
        System.out.println("Thread alive or not after starting: "+t.isAlive());
        t.join();
        System.out.println("Thread alive or not after terminating: "+t.isAlive());
    }
}
