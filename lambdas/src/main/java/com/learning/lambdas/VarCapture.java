package com.learning.lambdas;

public class VarCapture {
    interface MyFunc {
        int func(int n);
    }
    static void main() {
        int num = 10;
        MyFunc func = n -> {
            int v = num+n;
            //num++; This is not allowed as variable should be effectively final.
            return v;
        };
        System.out.println("Testing variable capture: "+func.func(5));
    }
}
