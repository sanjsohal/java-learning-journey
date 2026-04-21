package com.learning.multithreading;

class Restaurant {
    boolean isFoodPrepared = false;
    synchronized void orderFood() {
        System.out.println("Customer has ordered food");
        while(!isFoodPrepared) {
            try {
                wait();
            } catch(InterruptedException exc) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Order delivered");
    }
    synchronized void prepareFood() {
        System.out.println("Chef is preparing food");
        try {
            Thread.sleep(5000);
        } catch(InterruptedException exc) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Food prepared");
        isFoodPrepared = true;
        notify();
    }
}

public class InterthreadedCommunication1 {
    static void main() {
        Restaurant restaurant = new Restaurant();
        Thread customer = new Thread(restaurant::orderFood);
        Thread chef = new Thread(restaurant::prepareFood);
        customer.start();
        chef.start();
    }
}
