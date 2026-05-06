package com.learning.lambdas;

interface Func2 {
    boolean valid(int n);
}

public class LambdaDemo2 {
    static void main() {
        Func2 isEven = n -> n % 2 == 0;
        System.out.println("4 is even: " + isEven.valid(4));

        System.out.println("4 is odd: " + isEven.valid(4));

        System.out.println("5 is even: " +  isEven.valid(5));
        
    }
}
