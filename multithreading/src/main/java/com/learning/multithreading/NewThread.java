package com.learning.multithreading;

class NewThread implements Runnable{
    Thread t;
    NewThread() {
        t = new Thread(this);
    }
    public void run() {
        try {
            for(int i = 0; i<5; i++) {
                System.out.println("Child Thread: "+i);
                Thread.sleep(500);
            }
        } catch(InterruptedException exception) {
            System.out.println("Child thread interrupted");
        }
        System.out.println("Child Thread Exited");
    }
}
