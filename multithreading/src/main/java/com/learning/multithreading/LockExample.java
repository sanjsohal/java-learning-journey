package com.learning.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    static Lock lock = new ReentrantLock();
    static void main() throws InterruptedException {
        Thread t1 = new Thread(()-> {
            try {
                lock.lock();
                System.out.println("Thread-1 has acquired lock");
                sleep(5000);
            } finally {
                lock.unlock();
                System.out.println("Thread-1 has released lock");
            }
        });
        Thread t2 = new Thread(()-> {
           try {
               System.out.println("Thread-2 is trying to acquire lock");
               lock.lock();
               System.out.println("Thread-2 has acquired lock");
           } finally {
               lock.unlock();
               System.out.println("Thread-2 has released lock");
           }
        });
        t1.start();
        Thread.sleep(500);

        t2.start();
        Thread.sleep(1000);

        t2.interrupt();
        System.out.println("Thread-2 interrupted");

        t1.join();
        t2.join();
    }
    static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch(InterruptedException signal) {
            Thread.currentThread().interrupt();
        }
    }
}
