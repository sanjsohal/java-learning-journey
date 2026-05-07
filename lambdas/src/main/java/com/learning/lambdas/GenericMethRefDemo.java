package com.learning.lambdas;

public class GenericMethRefDemo {
    interface MyFunc<T> {
        int count(T[] arr, T val);
    }
    static class MyArrayOps {
        static <T> int countMatching(T[] arr, T val) {
            var count = 0;
            for(T v:arr) {
                if(v == val) count++;
            }
            return count;
        }
    }
    static <T> int countOp(MyFunc<T> func, T[] arr, T val) {
        return func.count(arr, val);
    }
    static void main() {
        Integer[] nums = {1, 2, 3, 4, 2, 3, 4, 4, 5};
        int vals;
        vals = countOp(MyArrayOps::countMatching, nums, 4);
        System.out.println("nums have "+vals + " 4s");

        String[] strs = {"One", "Two", "Three", "Two"};
        vals = countOp(MyArrayOps::countMatching, strs, "Two");
        System.out.println("vals have "+vals + " Two");
    }
}
