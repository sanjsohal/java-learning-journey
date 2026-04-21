package com.learning.multithreading;

class TaskPrinter implements Runnable {
    String message;
    TaskPrinter(String message) {
        this.message = message;
    }
    public void run() {
        System.out.println(message);
    }
}
public class PartialJoinDemo {
    public static void main(String...args) {
        Thread t1 = new Thread(new TaskPrinter("Task 1"));
        Thread t2 = new Thread(new TaskPrinter("Task 2"));
        Thread t3 = new Thread(new TaskPrinter("Task 3"));
        t1.start();
        t2.start();
        try {
            t1.join();
            t3.start();
        } catch(InterruptedException exc) {
            throw new RuntimeException();
        }
    }
}
