package com.java.generics;

public class GenMethDemo {
    static void main() {
        Integer[] nums = {1, 2, 3, 4, 5};
        if(isIn(2, nums))
            System.out.println("2 is in nums");
        else
            System.out.println("2 is not in nums");

        String[] strs = {"one", "two", "three", "four"};
        if(isIn("two", strs))
            System.out.println("two is in strs");
        else
            System.out.println("two is not in strs");

    }
    static <T extends Comparable<T>, V extends T> boolean isIn(T x, V[] y) {
        for (V v : y) {
            if (v == x) {
                return true;
            }
        }
        return false;
    }
}
