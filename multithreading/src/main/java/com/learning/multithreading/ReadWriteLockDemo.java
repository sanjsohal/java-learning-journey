package com.learning.multithreading;

public class ReadWriteLockDemo {
    static class ReadWriteLock {
        private int readers = 0;
        private boolean writersActive = false;
        synchronized void lockRead() {
            while(writersActive) {
                try {
                    wait();
                } catch(InterruptedException exc) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            readers++;
        }
        synchronized void unlockRead() {
            readers--;
            if(readers == 0) notifyAll();
        }
        synchronized void lockWrite() {
            while(readers > 0 || writersActive) {
                try {
                    wait();
                } catch(InterruptedException exc) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            writersActive = true;
        }
        synchronized void unlockWrite() {
            writersActive = false;
            notifyAll();
        }

        @Override
        public String toString() {
            return "[" +
                    "readers: " + readers +
                    ", writers: " + writersActive +
                    ']';
        }
    }
    static class Reader implements Runnable {
        private final ReadWriteLock lock;
        private final String name;
        Reader(ReadWriteLock lock, String name) {
            this.lock = lock;
            this.name = name;
        }
        public void run() {
            lock.lockRead();
            System.out.println(name + " -> started reading "+ lock);
            try {
                Thread.sleep(500);
            } catch(InterruptedException exc) {
                Thread.currentThread().interrupt();
                return;
            }
            System.out.println(name + " -> finished reading "+lock);
            lock.unlockRead();
        }
    }
    static class Writer implements Runnable {
        private final ReadWriteLock lock;
        private final String name;
        Writer(ReadWriteLock lock, String name) {
            this.lock = lock;
            this.name = name;
        }
        public void run() {
            lock.lockWrite();
            System.out.println(name + " -> started writing "+lock);
            try {
                Thread.sleep(500);
            } catch(InterruptedException exc) {
                Thread.currentThread().interrupt();
                return;
            }
            System.out.println(name + " -> finished writing "+lock);
            lock.unlockWrite();
        }
    }
    static void main() {
        ReadWriteLock lock = new ReadWriteLock();

        Reader reader1 = new Reader(lock, "Reader 1");
        Reader reader2 = new Reader(lock, "Reader 2");
        Reader reader3 = new Reader(lock, "Reader 3");
        Thread readerThread1 = new Thread(reader1);
        Thread readerThread2 = new Thread(reader2);
        Thread readerThread3 = new Thread(reader3);

        Writer writer1 = new Writer(lock, "Writer 1");
        Writer writer2 = new Writer(lock, "Writer 2");
        Thread writerThread1 = new Thread(writer1);
        Thread writerThread2 = new Thread(writer2);

        readerThread1.start();
        readerThread2.start();
        readerThread3.start();

        writerThread1.start();
        writerThread2.start();
    }
}
