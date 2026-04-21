package com.learning.multithreading;

public class SuspendResumeExample {
    static class NewThread implements Runnable {
        Thread t;
        String name;
        boolean suspendFlag = false;
        NewThread(String name) {
            this.name = name;
            t = new Thread(this, name);
        }
        public void run() {
            try {
                for(int i = 15; i>0; i--) {
                    System.out.println(name + " : "+i);
                    Thread.sleep(200);
                    synchronized (this) {
                        while(suspendFlag) {
                            wait();
                        }
                    }
                }
            } catch(InterruptedException exc) {
                System.out.println(name + " Interrupted");
            }
            System.out.println(name + " exited");
        }
        synchronized void suspend() {
            suspendFlag = true;
        }
        synchronized void resume() {
            suspendFlag = false;
            notify();
        }
    }
    static void main() {
        NewThread obj1 = new NewThread("ThreadA");
        obj1.t.start();
        NewThread obj2 = new NewThread("ThreadB");
        obj2.t.start();
        try {
            Thread.sleep(1000);
            obj1.suspend();
            System.out.println("Suspending thread A");
            Thread.sleep(1000);
            obj1.resume();
            System.out.println("Resuming thread A");
            obj2.suspend();
            System.out.println("Suspending thread B");
            Thread.sleep(1000);
            obj2.resume();
            System.out.println("Resuming thread B");

        } catch(InterruptedException exc) {
            System.out.println("Main thread interrupted");
        }
        try {
            System.out.println("Waiting for threads to finish");
            obj1.t.join();
            obj2.t.join();
        } catch(InterruptedException exc) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread exiting");
    }
}
