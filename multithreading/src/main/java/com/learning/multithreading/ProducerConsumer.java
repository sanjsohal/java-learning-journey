package com.learning.multithreading;

class Q {
    int i = 0;
    boolean isValueSet = false;
    synchronized void put(int i) {
        while(isValueSet) {
            try {
                wait();
            } catch(InterruptedException exc) {
                System.out.println("Exception caught in put method");
            }
        }
        this.i = i;
        System.out.println("Put: "+i);
        isValueSet = true;
        notify();
    }
    synchronized int get() {
        while(!isValueSet) {
            try {
                wait();
            } catch(InterruptedException exc) {
                System.out.println("Exception caught ing et method");
            }
        }
        System.out.println("Got: "+i);
        isValueSet = false;
        notify();
        return i;
    }
}
class Producer implements Runnable {
    Q q;
    Producer(Q q) {
        this.q = q;
    }
    public void run() {
        int i = 0;
        while(true) {
            q.put(i++);
        }
    }
}
class Consumer implements Runnable {
    Q q;
    Consumer(Q q) {
        this.q = q;
    }
    public void run() {
        while(true) {
            q.get();
        }
    }
}
public class ProducerConsumer {
    static void main() {
        Q q = new Q();
        Producer producer = new Producer(q);
        Consumer consumer = new Consumer(q);
        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);
        producerThread.start();
        consumerThread.start();
    }
}
