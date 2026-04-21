package com.learning.multithreading;

class BabyThread implements Runnable {
    Thread t;
    String name;
    BabyThread(String name) {
        this.name = name;
        t = new Thread(this, name);
        System.out.println("Baby thread: "+name);
    }
    public void run() {
        try {
            for(int i = 0; i<5; i++) {
                System.out.println(name + " : "+i);
                Thread.sleep(1000);
            }
        } catch(InterruptedException ex) {
            System.out.println(name + " interrupted");
        }
        System.out.println(name + " exited");
    }
}
public class DemoJoin {
    public static void main(String...args) {
        BabyThread b1 = new BabyThread("Thread1");
        BabyThread b2 = new BabyThread("Thread2");
        BabyThread b3 = new BabyThread("Thread3");
        b1.t.start();
        b2.t.start();
        b3.t.start();
        System.out.println(b1.name +" is: "+ b1.t.isAlive());
        System.out.println(b2.name +" is: "+ b2.t.isAlive());
        System.out.println(b3.name +" is: "+ b3.t.isAlive());
        try {
            b1.t.join();
            b2.t.join();
            b3.t.join();
        } catch(InterruptedException exc) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread exited");
        System.out.println(b1.name +" is: "+ b1.t.isAlive());
        System.out.println(b2.name +" is: "+ b2.t.isAlive());
        System.out.println(b3.name +" is: "+ b3.t.isAlive());
    }

}
