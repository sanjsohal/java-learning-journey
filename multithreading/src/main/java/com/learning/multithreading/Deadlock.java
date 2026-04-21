package com.learning.multithreading;

public class Deadlock implements Runnable {
    A a = new A();
    B b = new B();
    Thread t;
    Deadlock() {
        Thread.currentThread().setName("MainThread");
        t = new Thread(this, "RacingThread");
    }
    void deadlockStart() {
        t.start();
        a.foo(b);
        System.out.println("Back in main thread");
    }
    public void run() {
        b.bar(a);
        System.out.println("Back in RacingThread");
    }
    static class A {
        synchronized void foo(B b) {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " entered A.foo");
            try {
                Thread.sleep(500);
            } catch(InterruptedException exc) {
                System.out.println("Exception caught in A's foo");
            }
            System.out.println(threadName + " going to call B's last method");
            b.last();
        }
        synchronized void last() {
            System.out.println("Inside A's last method");
        }
    }
    static class B {
        synchronized void bar(A a) {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " entered B.bar");
            try {
                Thread.sleep(500);
            } catch(InterruptedException exc) {
                System.out.println("Exception caught in B's bar");
            }
            System.out.println("Going to call A's last method");
            a.last();
        }
        synchronized void last() {
            System.out.println("Inside B's last method");
        }
    }

    static void main() {
        Deadlock d = new Deadlock();
        d.deadlockStart();
    }
}
