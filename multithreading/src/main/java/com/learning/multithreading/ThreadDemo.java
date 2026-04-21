package com.learning.multithreading;

public class ThreadDemo {
    public static void main(String...args) {
        NewThread nt = new NewThread();
        nt.t.start();
        try {
            for(int i = 0; i<5; i++) {
                System.out.println("Main Thread: "+i);
                Thread.sleep(1000);
            }
        } catch(InterruptedException exception) {
            System.out.println("Main Thread interrupted");
        }
        System.out.println("Main Thread Exited");
    }
}
