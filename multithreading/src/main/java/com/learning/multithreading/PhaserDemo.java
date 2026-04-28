package com.learning.multithreading;

import java.util.concurrent.Phaser;

public class PhaserDemo {
    static void main() {
        Phaser phaser = new Phaser(1);
        int currentPhase;
        System.out.println("Starting");
        new Thread(new MyThread(phaser, "A")).start();
        new Thread(new MyThread(phaser, "B")).start();
        new Thread(new MyThread(phaser, "C")).start();
        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + currentPhase + " completed");

        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + currentPhase + " completed");

        phaser.arriveAndDeregister();
        if(phaser.isTerminated()) {
            System.out.println("Phaser is terminated");
        }
    }
    static class MyThread implements Runnable {
        Phaser phaser;
        String name;
        MyThread(Phaser phaser, String name) {
            this.phaser = phaser;
            this.name = name;
            this.phaser.register();
        }
        public void run() {
            int phase = phaser.getPhase();
            System.out.println(name + " Beginning Phase One");
            phaser.arriveAndAwaitAdvance();
            try {
                Thread.sleep(1000);
            } catch(InterruptedException exc) {
                System.out.println(exc);
            }
            System.out.println(name + " Beginning Phase Two");
            phaser.arriveAndAwaitAdvance();
            try {
                Thread.sleep(1000);
            } catch(InterruptedException exc) {
                System.out.println(exc);
            }
        }
    }
}
