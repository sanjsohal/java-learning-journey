package com.learning.multithreading;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinPoolDemo {
    static void main() {
        double[] data = new double[100000];
        for (int i = 0; i < data.length; i++) {
            data[i] = (double) i;
        }
        System.out.println("Some values before transformation");
        for(int i=0; i<10; i++) {
            System.out.println(data[i]);
        }
        ForkJoinPool pool = new ForkJoinPool();
        Transformer transformer = new Transformer(data, 0, data.length);
        pool.invoke(transformer);
        System.out.println("Some values after transformation");
        for(int i=0; i<10; i++) {
            System.out.println(data[i]);
        }
    }
    static class Transformer extends RecursiveAction {
        double[] data;
        int start;
        int end;

        Transformer(double[] data, int start, int end) {
            this.data = data;
            this.start = start;
            this.end = end;
        }
        @Override
        public void compute() {
            if(end - start <= 1000) {
                for(int i = start; i < end; i++) {
                    data[i] = Math.sqrt(data[i]);
                }
            } else {
                int middle = (start + end) / 2;
                invokeAll(new Transformer(data, start, middle), new Transformer(data, middle, end));
            }
        }
    }
}
