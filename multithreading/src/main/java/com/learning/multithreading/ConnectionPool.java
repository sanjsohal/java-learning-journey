package com.learning.multithreading;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class ConnectionPool {
    AtomicBoolean isShutdown = new AtomicBoolean(false);
    Semaphore sem;
    private final ConcurrentLinkedQueue<String> availableConnections;
    int poolSize;
    public ConnectionPool(int poolSize) {
        this.poolSize = poolSize;
        sem = new Semaphore(poolSize, true);
        availableConnections = new ConcurrentLinkedQueue<>();
        for(int i = 1; i<=poolSize; i++) {
            availableConnections.add("connection-"+i);
        }
    }
    public String acquireConnection() {
        if (isShutdown.get()) {
            System.out.println(Thread.currentThread().getName() + " rejected - pool is shut down!");
            return null;
        }
        try {
            boolean isConnectionAcquired = sem.tryAcquire(2, TimeUnit.SECONDS);
            if(!isConnectionAcquired) {
                System.out.println(Thread.currentThread().getName()+" timed out!");
                return null;
            }
        } catch(InterruptedException exc) {
            Thread.currentThread().interrupt();
        }
        return availableConnections.poll();
    }
    public void releaseConnection(String connection) {
        availableConnections.offer(connection);
        sem.release();
    }
    public int availableConnections() {
        return sem.availablePermits();
    }
    void shutdownPool() {
        isShutdown.set(true);
        try {
            sem.acquire(poolSize); // blocks until ALL permits are free
            System.out.println("Pool shut down cleanly.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
