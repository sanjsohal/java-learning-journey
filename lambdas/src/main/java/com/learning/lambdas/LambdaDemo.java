package com.learning.lambdas;

interface MyFunc {
    double getValue();
}
public class LambdaDemo {
    static void main() {
        MyFunc myVal = () -> 121.23;
        System.out.println("Fixed value:" +myVal.getValue());

        MyFunc randomValue = () -> Math.random() * 100;
        System.out.println("Random value: "+randomValue.getValue());

        System.out.println("Random value: "+randomValue.getValue());

    }
}
