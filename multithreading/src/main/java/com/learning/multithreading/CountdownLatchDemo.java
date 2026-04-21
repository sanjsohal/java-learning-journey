package com.learning.multithreading;

import java.util.concurrent.CountDownLatch;

public class CountdownLatchDemo {
    static void main() {
        CountDownLatch cdl = new CountDownLatch(5);
        new Thread(new MyThread(cdl)).start();
        try {
            cdl.await();
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Done");
    }
    static class MyThread implements Runnable {
        CountDownLatch cdl;
        MyThread(CountDownLatch cdl) {
            this.cdl = cdl;
        }
        public void run() {
            for(int i = 0; i<5; i++) {
                System.out.println("Thread: "+i);
                cdl.countDown();
            }
        }
    }
}
