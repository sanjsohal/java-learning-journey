package com.learning.multithreading;

class ChildThread extends Thread {
    ChildThread() {
        super("Child Thread");
        System.out.println("Child Thread: "+ this);
    }
    public void run() {
        try {
            for(int i = 0; i<5; i++) {
                System.out.println("Child Thread: "+i);
                Thread.sleep(500);
            }
        } catch(InterruptedException exc) {
            System.out.println("Child Thread interrupted");
        }
        System.out.println("Child Thread exited");
    }
}
public class ExtendDemo {
    public static void main(String...args) {
        ChildThread t = new ChildThread();
        t.start();
        try {
            for(int i = 0; i<5; i++) {
                System.out.println("Main Thread: "+i);
                Thread.sleep(1000);
            }
        } catch(InterruptedException exc) {
            System.out.println("Main Thread interrupted");
        }
        System.out.println("Main Thread exited");
    }
}
