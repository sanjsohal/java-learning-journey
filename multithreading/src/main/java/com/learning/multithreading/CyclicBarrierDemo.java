package com.learning.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    static class MyThread implements Runnable {
        CyclicBarrier cb;
        String name;
        MyThread(CyclicBarrier cb, String name) {
            this.cb = cb;
            this.name = name;
        }
        public void run() {
            System.out.println(name);
            try {
                cb.await();
            } catch(BrokenBarrierException ex) {
                System.out.println("Barrier is broken");
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
    static class BarrierWork implements Runnable {
        public void run() {
            System.out.println("Barrier Thread executed");
        }
    }
    static void main() {
        CyclicBarrier cb = new CyclicBarrier(3, new BarrierWork());
        System.out.println("Starting");
        new Thread(new MyThread(cb, "A")).start();
        new Thread(new MyThread(cb, "B")).start();
        new Thread(new MyThread(cb, "C")).start();
        new Thread(new MyThread(cb, "X")).start();
        new Thread(new MyThread(cb, "Y")).start();
        new Thread(new MyThread(cb, "Z")).start();
    }
}
