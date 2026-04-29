package com.learning.multithreading;

import java.util.concurrent.Phaser;

public class PhaserDemo2 {
    static class MyPhaser extends Phaser {
        int numOfPhases;
        MyPhaser(int parties, int phasesCount) {
            super(parties);
            numOfPhases = phasesCount -1;
        }

        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            System.out.println("Phase " +phase + " completed.");
            return phase == numOfPhases || registeredParties == 0;
        }
    }
    static void main() {
        MyPhaser phaser = new MyPhaser(1, 4);
        new Thread(new MyThread(phaser, "A")).start();
        new Thread(new MyThread(phaser, "B")).start();
        new Thread(new MyThread(phaser, "C")).start();
        while(!phaser.isTerminated()) {
            phaser.arriveAndAwaitAdvance();
        }
        System.out.println("Phase is terminated");
    }
    static class MyThread implements Runnable {
        Phaser phaser;
        String name;
        MyThread(Phaser ph, String name) {
            phaser = ph;
            this.name = name;
            phaser.register();
        }
        public void run() {
            while(!phaser.isTerminated()) {
                System.out.println(name + " beginning "+phaser.getPhase());
                phaser.arriveAndAwaitAdvance();
            }
            try {
                Thread.sleep(100);
            } catch(InterruptedException exc) {
                System.out.println(exc);
            }
        }
    }

}
