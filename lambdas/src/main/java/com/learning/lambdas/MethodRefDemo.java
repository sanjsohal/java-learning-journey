package com.learning.lambdas;

public class MethodRefDemo {
    interface StringFunc {
        String func(String input);
    }
    static class MyStringOps {
        static String strReverse(String input) {
            var result = "";
            for(int i=input.length()-1;i>=0;i--) {
                result+=input.charAt(i);
            }
            return result;
        }
    }
    static String stringOp(StringFunc func, String input) {
        return func.func(input);
    }
    static void main() {
        String input = "This is example of Method reference";
        String output = stringOp(MyStringOps::strReverse, input);
        System.out.println("Input string: "+input);
        System.out.println("Reverse of input is: "+output);
    }
}
