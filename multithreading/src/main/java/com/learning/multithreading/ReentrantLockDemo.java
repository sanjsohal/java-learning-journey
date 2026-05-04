package com.learning.multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    static void main() {
        ReentrantLock lock = new ReentrantLock();
        new Thread(new LockThread(lock,"A")).start();
        new Thread(new LockThread(lock, "B")).start();
    }
    static class LockThread implements Runnable {
        ReentrantLock lock;
        String name;
        LockThread(ReentrantLock lock, String name) {
            this.lock = lock;
            this.name = name;
        }
        public void run() {
            try {
                lock.lock();
                System.out.println(name + " acquired lock");
                Shared.count++;
                System.out.println(name + " increased it to "+Shared.count);
            } finally {
                lock.unlock();
                System.out.println(name + " released lock");
            }
        }
    }

}
class Shared {
    static int count;
}
