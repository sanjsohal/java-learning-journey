package com.learning.multithreading;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinExperiment2 {
    static void main() {
        double[] nums = new double[100000];
        for(int i=0; i<nums.length; i++) {
            nums[i] = (double)i%2 == 0 ? i: -i;
        }
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new Sum(0, nums.length, nums));
    }
    static class Sum extends RecursiveTask<Double> {
        int start;
        int end;
        double[] data;
        public Sum(int start, int end, double[] data) {
            this.start = start;
            this.end = end;
            this.data = data;
        }
        @Override
        protected Double compute() {
            double sum = 0;
            if(end - start <= 1000) {
                for (int i = start; i < end; i++) {
                    sum += data[i];
                }
            } else {
                int middle = (start + end) / 2;
                Sum sumA = new Sum(start, middle, data);
                Sum sumB = new Sum(middle, end, data);
                sumA.fork();
                sumB.fork();
                sum = sumA.join() + sumB.join();
            }

            return sum;
        }
    }
}
