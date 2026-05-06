package com.learning.lambdas;

interface Factor {
    boolean test(int n, int x);
}
public class LambdaDemo3 {
    static void main() {
        Factor isFactorOf = (n, x) -> n%x == 0;
        System.out.println("10 is a factor of 2:" + isFactorOf.test(10, 2));
        System.out.println("5 is a factor of 3: "+ isFactorOf.test(5, 3));
    }
}
