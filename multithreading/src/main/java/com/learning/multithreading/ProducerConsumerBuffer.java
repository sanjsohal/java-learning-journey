package com.learning.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class ProducerConsumerBuffer {
    static class Buffer {
        Queue<Integer> queue = new LinkedList<>();
        int capacity = 3;
        synchronized void produce(int item) {
            while(queue.size() == capacity) {
                try {
                    wait();
                } catch(InterruptedException exc) {
                    Thread.currentThread().interrupt();
                }
            }
            queue.add(item);
            System.out.println(Thread.currentThread().getName() + " -> produced: "+item+" "+this);
            notify();
        }
        synchronized void consume() {
            while(queue.isEmpty()) {
                try {
                    wait();
                } catch(InterruptedException exc) {
                    Thread.currentThread().interrupt();
                }
            }
            int itemConsumed = queue.poll();
            System.out.println(Thread.currentThread().getName()+" -> consumed: "+itemConsumed+" "+ this);
            notify();
        }

        public String toString() {
            return "[buffer: "+queue.stream().map(String::valueOf).collect(Collectors.joining(","))+"]";
        }
    }

    static void main() {
        Buffer buffer = new Buffer();
        Thread producer = new Thread(() -> {
            for(int i = 1; i<=10; i++) {
                buffer.produce(i);
            }
        }, "Producer");
        Thread consumer = new Thread(() -> {
            for(int i = 1; i<= 10; i++) {
                buffer.consume();
            }
        }, "Consumer");
        producer.start();
        consumer.start();
    }
}
