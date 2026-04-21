package com.learning.multithreading;

class MyThread extends Thread{
    Thread t;
    MyThread(Thread t) {
        this.t = t;
    }
    public void run() {
        try {
            t.join();
        } catch(InterruptedException exc) {
            System.out.println("Finished");
        }
    }
}
public class DeadlockScenario {
    static void main() {
        MyThread t1 = new MyThread(null);
        MyThread t2 = new MyThread(t1);
        t1.t = t2;
        t1.start();
        t2.start();
    }
}
