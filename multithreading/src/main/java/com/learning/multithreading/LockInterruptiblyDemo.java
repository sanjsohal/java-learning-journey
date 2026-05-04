package com.learning.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockInterruptiblyDemo {
    static Lock lock = new ReentrantLock();
    static void main() throws InterruptedException {
        Thread t1 = new Thread(()-> {
           try {
               lock.lockInterruptibly();
               System.out.println("Thread-1 has acquired lock");
               sleep(5000);
           } catch(InterruptedException exc) {
               Thread.currentThread().interrupt();
           }finally {
               lock.unlock();
               System.out.println("Thread-1 has released lock");
           }
        });
        Thread t2 = new Thread(()-> {
           System.out.println("Thread-2 is trying to acquire lock");
           try {
               lock.lockInterruptibly();
               try {
                   System.out.println("Thread-2 acquired lock");
               } finally {
                   lock.unlock();
               }
           } catch(InterruptedException exc) {
               Thread.currentThread().interrupt();
               System.out.println("Thread-2 interrupted while waiting");
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
        } catch(InterruptedException exc) {

        }
    }
}
