package com.learning.multithreading;

import java.util.concurrent.Semaphore;

public class SemaDemo {
    static void main() {
        Semaphore sem = new Semaphore(1);
        Thread increaseThread = new Thread(new IncThread("IncThread", sem));
        Thread decreaseThread = new Thread(new DecThread("DecThread", sem));
        increaseThread.start();
        decreaseThread.start();
    }
    static class Shared {
        static int count = 0;
    }
    static class IncThread implements Runnable {
        String name;
        Semaphore sem;
        IncThread(String name, Semaphore sem) {
            this.name = name;
            this.sem = sem;
        }
        public void run() {
            try {
                sem.acquire();
                for(int i = 0; i<5; i++) {
                    System.out.println(name + " : "+Shared.count++);
                }
                sem.release();
            } catch (InterruptedException e) {
                System.out.println("Exception in "+name);
            }
        }
    }
    static class DecThread implements Runnable {
        String name;
        Semaphore sem;
        DecThread(String name, Semaphore sem) {
            this.name = name;
            this.sem = sem;
        }
        public void run() {
            try {
                sem.acquire();
                for(int i = 0; i<5; i++) {
                    System.out.println(name + " : "+Shared.count--);
                }
                sem.release();
            } catch (InterruptedException e) {
                System.out.println("Exception in "+name);
            }
        }
    }
}




