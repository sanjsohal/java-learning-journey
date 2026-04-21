package com.learning.multithreading;

public class EvenOddPrinter {
    static class Printer {
        int counter = 1;
        int limit = 10;
        synchronized void printOdd() {
            while(counter <= limit) {
                while(counter%2 == 0) {
                    if(counter > limit) return;
                    try {
                        wait();
                    } catch(InterruptedException exc) {
                        System.out.println("Exception occurred in printOdd() method");
                    }
                }
                if(counter > limit) return;
                System.out.println(Thread.currentThread().getName()+" -> "+counter);
                counter++;
                notify();
            }

        }

        synchronized void printEven() {
            while(counter <= limit) {
                while(counter%2 != 0) {
                    if(counter > limit) return;
                    try {
                        wait();
                    } catch(InterruptedException exc) {
                        System.out.println("Exception occurred in printEven() method");
                    }
                }
                System.out.println(Thread.currentThread().getName() + " -> "+counter);
                counter++;
                notify();
            };

        }
    }
    static void main() {
        Printer printer = new Printer();
        Thread oddPrinter = new Thread(printer::printOdd, "OddThread");
        Thread evenPrinter = new Thread(printer::printEven, "EvenThread");
        oddPrinter.start();
        evenPrinter.start();
    }
}
