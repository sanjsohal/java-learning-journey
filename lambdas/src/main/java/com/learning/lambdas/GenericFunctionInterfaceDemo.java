package com.learning.lambdas;

interface SomeFunc<T> {
    T func(T val);
}
public class GenericFunctionInterfaceDemo {
    static void main() {
        SomeFunc<Integer> factorial = n -> {
            var result = 1;
            for(int i=1; i<=n; i++) {
                result*=i;
            }
            return result;
        };
        SomeFunc<String> reverse = str -> {
            var result = "";
            for(int i=str.length()-1; i>=0; i--) {
                result+=str.charAt(i);
            }
            return result;
        };
        System.out.println("Factorial of 5 is: "+factorial.func(5));
        System.out.println("Reverse of Lambda is: "+reverse.func("Lambda"));
    }
}
