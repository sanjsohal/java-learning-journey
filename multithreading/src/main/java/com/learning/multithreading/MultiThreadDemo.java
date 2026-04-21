package com.learning.multithreading;

class Child implements Runnable {
    Thread t;
    String name;
    Child(String name) {
        this.name = name;
        t = new Thread(this, name);
        System.out.println("Child thread: "+name);
    }
    public void run() {
        try {
            for(int i = 0; i<5; i++) {
                System.out.println(name + " thread: "+i);
                Thread.sleep(1000);
            }
        } catch(InterruptedException exc) {
            System.out.println(name + " thread interrupted");
        }
        System.out.println(name + " thread exited");
    }
}
public class MultiThreadDemo {
    public static void main(String...args) {
        Child t1 = new Child("Thread 1");
        Child t2 = new Child("Thread 2");
        Child t3 = new Child("Thread 3");
        t1.t.start();
        t2.t.start();
        t3.t.start();
        try {
            Thread.sleep(10000);
        } catch(InterruptedException exc) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread exited");
    }
}
