package com.learning.lambdas;

interface NumericFunc {
    int fact(int n);
}
public class BlockLambdaDemo {
    static void main() {
        NumericFunc factorial = n -> {
            var result = 1;
            for(int i = 1; i<=n; i++) {
                result*=i;
            }
            return result;
        };
        System.out.println("Factorial of 5 is: "+factorial.fact(5));
    }
}
