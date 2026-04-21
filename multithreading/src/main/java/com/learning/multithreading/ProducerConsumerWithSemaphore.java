package com.learning.multithreading;

import java.util.concurrent.Semaphore;

public class ProducerConsumerWithSemaphore {
    static void main() {
        Q q = new Q();
        new Thread(new Producer(q)).start();
        new Thread(new Consumer(q)).start();
    }
    static class Q {
        Semaphore semProd = new Semaphore(1);
        Semaphore semCon = new Semaphore(0);
        int i;
        void put(int i) {
            try {
                semProd.acquire();
            } catch (InterruptedException e) {
                System.out.println("Exception caught in put method: "+e);
            }
            this.i = i;
            System.out.println("Put: "+i);
            semCon.release();
        }
        void get() {
            try {
                semCon.acquire();
            } catch(InterruptedException e) {
                System.out.println("Exception caught in get method: "+e);
            }
            System.out.println("Got: "+i);
            semProd.release();
        }
    }
    static class Producer implements Runnable {
        Q q;
        Producer(Q q) {
            this. q = q;
        }
        public void run() {
            for(int i = 0; i<20; i++) {
                q.put(i);
            }
        }
    }
    static class Consumer implements Runnable {
        Q q;
        Consumer(Q q) {
            this.q = q;
        }
        public void run() {
            for(int i = 0; i<20; i++) {
                q.get();
            }
        }
    }
}
