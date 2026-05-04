package com.learning.multithreading;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class FJExperiment {
    static class Transformer extends RecursiveAction {
        double[] data;
        int start;
        int end;
        int seqThreshold;
        public Transformer(double[] data, int start, int end, int seqThreshold) {
            this.data = data;
            this.start = start;
            this.end = end;
            this.seqThreshold = seqThreshold;
        }
        public void compute() {
            if(end - start <= seqThreshold) {
                for(int i=start; i<=end; i+=seqThreshold) {
                    if(i%2 == 0) {
                        data[i] = Math.sqrt(data[i]);
                    } else {
                        data[i] = Math.cbrt(data[i]);
                    }
                }
            } else {
                int middle = (start + end) / 2;
                invokeAll(new Transformer(data, start, middle, seqThreshold),  new Transformer(data, middle, end, seqThreshold));
            }
        }
    }
    static void main(String...args) {
        if(args.length != 2) {
            System.out.println("Invalid number of arguments");
            return;
        }
        int pLevel =  Integer.parseInt(args[0]);
        int seqThreshold = Integer.parseInt(args[1]);
        double[] nums = new double[100000];
        for(int i=0; i<nums.length; i++) nums[i] = (double)i;
        System.out.println("Some elements before transformation");
        for(int i=0; i<10; i++) System.out.println(nums[i]);
        long t1 = System.nanoTime();
        ForkJoinPool pool = new ForkJoinPool(pLevel);
        Transformer transformer = new Transformer(nums, 0, nums.length, seqThreshold);
        pool.invoke(transformer);
        long t2 = System.nanoTime();
        System.out.println("Some elements after transformation");
        for(int i=0; i<10; i++) System.out.println(nums[i]);
        System.out.println("Time taken: "+(t2-t1) + " ms");
    }
}
