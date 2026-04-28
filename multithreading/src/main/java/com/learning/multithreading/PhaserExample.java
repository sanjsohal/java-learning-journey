package com.learning.multithreading;

import java.util.concurrent.Phaser;

public class PhaserExample {
     static void main() {
        Phaser phaser = new Phaser(3); // 3 registered parties

        // Worker threads
        Runnable worker = () -> {
            System.out.println(Thread.currentThread().getName() + " is performing work in phase " + phaser.getPhase());
            phaser.arriveAndAwaitAdvance(); // Arrive and wait for others
            System.out.println(Thread.currentThread().getName() + " entered next phase.");
        };

        // Start worker threads
        for (int i = 0; i < 3; i++) {
            new Thread(worker, "Worker-" + i).start();
        }

        // Monitor thread waiting for phase 0 to finish
        new Thread(() -> {
            int currentPhase = phaser.getPhase();
            System.out.println("Monitor is waiting for phase " + currentPhase + " to complete.");

            // This will block until the phase advances to 1
            phaser.awaitAdvance(currentPhase);

            System.out.println("Monitor detected that Phase " + currentPhase + " is finished. Proceeding...");
        }).start();
    }
}
