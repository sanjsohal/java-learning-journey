package com.java.generics;

class Stats<T extends Number> {
    T[] obj;
    Stats(T[] obj) {
        this.obj = obj;
    }
    double average() {
        double sum = 0.0;
        for(int i = 0; i<obj.length; i++) {
            sum+=obj[i].doubleValue();
        }
        return sum/obj.length;
    }
    boolean isSameAverage(Stats<?> obj) {
        return average() == obj.average();
    }
}
public class WildcardDemo {
    static void main() {
        Stats<Integer> intNums = new Stats<>(new Integer[]{1, 2, 3, 4, 5});
        Stats<Double> doubleNums = new Stats<>(new Double[]{1.1, 2.2, 3.3, 4.4, 5.5});
        Stats<Float> floatNums = new Stats<>(new Float[]{1.0F, 2.0F, 3.0F, 4.0F, 5.0F});
        System.out.printf("Average of integers: %f \n", intNums.average());
        System.out.printf("Average of doubles: %f \n", doubleNums.average());
        System.out.printf("Average of floats: %f \n", floatNums.average());

        if(intNums.isSameAverage(doubleNums)) {
            System.out.println("Average of integer and double is same");
        } else {
            System.out.println("Average of integer and double are different");
        }
        if(intNums.isSameAverage(floatNums)) {
            System.out.println("Average of integer and float is same");
        } else {
            System.out.println("Average of integer and float are different");
        }
    }
}
