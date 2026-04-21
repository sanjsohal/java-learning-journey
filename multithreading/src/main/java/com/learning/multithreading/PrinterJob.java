package com.learning.multithreading;

class Printer {
    synchronized void printJob(String threadName, int lines) {
        for(int i = 1; i<=lines; i++) {
            System.out.println(threadName+": Line" + i);
            try {
                Thread.sleep(1000);
            } catch(InterruptedException exc) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
public class PrinterJob {
    static void main() {
        Printer printer = new Printer();
        Thread t1 = new Thread(() -> printer.printJob("Thread-1", 5));
        Thread t2 = new Thread(() -> printer.printJob("Thread-2", 3));
        Thread t3 = new Thread(() -> printer.printJob("Thread-3", 4));
        t1.start();
        t2.start();
        t3.start();
    }
}
