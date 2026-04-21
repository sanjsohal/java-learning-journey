package com.learning.multithreading;


public class MainApp implements Runnable {
    Thread t;
    ConnectionPool pool;
    String name;
    public MainApp(ConnectionPool pool, String name) {
        this.pool = pool;
        this.name = name;
        t = new Thread(this, name);
    }

    static void main() {
        ConnectionPool connectionPool = new ConnectionPool(3);
        for (int i = 1; i <= 10; i++) {
            new MainApp(connectionPool, "Thread-" + i).t.start();
        }
        connectionPool.shutdownPool();

    }
    public void run() {
        if(pool.isShutdown.get()) return;
        String connection = pool.acquireConnection();
        if(connection == null) return;
        System.out.println(name + " acquired "+connection);
        try {
            Thread.sleep(1000 + (long)(Math.random() * 2000));
        } catch(InterruptedException exc) {
            Thread.currentThread().interrupt();
        }
        System.out.println(name + " released "+connection);
        pool.releaseConnection(connection);
    }
}

