package com.learning.multithreading;
class NumberPrinter implements Runnable {
    private int startIndex;
    private int endIndex;
    public NumberPrinter(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }
    public void run() {
        for(int i = startIndex; i <= endIndex; i++) {
            System.out.println(i);
        }
    }
}
public class JoinMethodDemo {
    public static void main(String...args) {
        Thread t1 = new Thread(new NumberPrinter(1, 5));
        Thread t2 = new Thread(new NumberPrinter(6, 10));
        t1.start();
        try {
            t1.join();
        } catch(InterruptedException exc) {
            throw new RuntimeException();
        }
        t2.start();
    }
}
