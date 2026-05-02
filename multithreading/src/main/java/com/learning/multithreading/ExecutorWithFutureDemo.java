package com.learning.multithreading;

import java.util.concurrent.*;

public class ExecutorWithFutureDemo {
    static void main() {
        ExecutorService es = Executors.newFixedThreadPool(3);
        Future<Integer> f1;
        Future<Double> f2;
        Future<Integer> f3;
        System.out.println("Starting...");
        f1 = es.submit(new Sum(5));
        f2 = es.submit(new Hypotenuse(10.0, 5.0));
        f3 = es.submit(new Factorial(5));
        try {
            System.out.println(f1.get(10, TimeUnit.MILLISECONDS));
            System.out.println(f2.get(10, TimeUnit.MILLISECONDS));
            System.out.println(f3.get(10, TimeUnit.MILLISECONDS));
        } catch(InterruptedException | ExecutionException | TimeoutException exc) {
            System.out.println(exc);
        }
        es.shutdown();
        System.out.println("Done!");
    }
    static class Sum implements Callable<Integer> {
        int num;
        Sum(int num) {
            this.num = num;
        }
        public Integer call() {
            int sum = 0;
            for(int i=1; i<=num; i++) {
                sum+=i;
            }
            return sum;
        }
    }

    static class Hypotenuse implements Callable<Double> {
        double side1;
        double side2;
        Hypotenuse(double side1, double side2) {
            this.side1 = side1;
            this.side2 = side2;
        }
        public Double call() {
            return Math.hypot(side1, side2);
        }
    }

    static class Factorial implements Callable<Integer> {
        int num;
        Factorial(int num) {
            this.num = num;
        }
        public Integer call() {
            int fact = 1;
            for(int i = 1; i<=num; i++) {
                fact*=i;
            }
            return fact;
        }
    }

}
