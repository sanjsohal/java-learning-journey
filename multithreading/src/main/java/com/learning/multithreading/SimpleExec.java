package com.learning.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleExec {
    static void main() {
        CountDownLatch cdl = new CountDownLatch(5);
        CountDownLatch cdl2 = new CountDownLatch(5);
        CountDownLatch cdl3 = new CountDownLatch(5);
        CountDownLatch cdl4 = new CountDownLatch(5);
        CountDownLatch cdl5 = new CountDownLatch(5);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        System.out.println("Starting...");
        executorService.execute(new MyThread(cdl, "A"));
        executorService.execute(new MyThread(cdl2, "B"));
        executorService.execute(new MyThread(cdl3, "C"));
        executorService.execute(new MyThread(cdl4, "D"));
        executorService.execute(new MyThread(cdl5, "E"));
        try {
            cdl.await();
            cdl2.await();
            cdl3.await();
            cdl4.await();
            cdl5.await();
        } catch(InterruptedException exc) {
            System.out.println(exc);
        }
        executorService.shutdown();
    }
    static class MyThread implements Runnable {
        CountDownLatch cdl;
        String name;
        MyThread(CountDownLatch cdl, String name) {
            this.cdl = cdl;
            this.name = name;
        }
        public void run() {
            for(int i=0; i<5; i++) {
                System.out.println(name + " : "+i);
                cdl.countDown();
            }
        }
    }

}
