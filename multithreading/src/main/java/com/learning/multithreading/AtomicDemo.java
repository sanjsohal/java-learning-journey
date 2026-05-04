package com.learning.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
    static void main() {
        new Thread(new AtomicThread("A")).start();
        new Thread(new AtomicThread("B")).start();
        new Thread(new AtomicThread("C")).start();
    }
    static class AtomicThread implements Runnable {
        String name;
        AtomicThread(String name) {
            this.name = name;
        }
        public void run() {
            System.out.println("Starting: "+name);
            for(int i=1; i<=3; i++) {
                System.out.println(name + " got: " + Shared.ai.getAndSet(i));
            }
        }
    }
    static class Shared {
        static AtomicInteger ai = new AtomicInteger(0);
    }
}
