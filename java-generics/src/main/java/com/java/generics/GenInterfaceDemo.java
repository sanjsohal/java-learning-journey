package com.java.generics;

interface MinMax<T extends Comparable<T>> {
    T min();
    T max();
}
class MinMaxDemo<T extends Comparable<T>> implements MinMax<T> {
    T[] obj;
    MinMaxDemo(T[] obj) {
        this.obj = obj;
    }
    public T min() {
        T val = obj[0];
        for (T t : obj) {
            if (t.compareTo(val) < 0) {
                val = t;
            }
        }
        return val;
    }
    public T max() {
        T val = obj[0];
        for(T t: obj) {
            if(t.compareTo(val) > 0) {
                val = t;
            }
        }
        return val;
    }
}
public class GenInterfaceDemo {
    static void main() {
        Integer[] nums = {1, 2, 3, 4, 5};
        MinMaxDemo<Integer> demo = new MinMaxDemo<>(nums);
        System.out.println("Min: "+demo.min());
        System.out.println("Max: "+demo.max());
    }
}
