package com.learning.lambdas;

public class MethodRefDemo2 {
    interface StringFunc {
        String func(String input);
    }
    static class MyStringOps {
        String stringReverse(String input) {
            var res = "";
            for(int index=input.length()-1; index>=0; index--) {
                res+=input.charAt(index);
            }
            return res;
        }
    }
    static String strOp(StringFunc func, String input) {
        return func.func(input);
    }
    static void main() {
        String input = "This is another example of Method reference";
        MyStringOps strOps = new MyStringOps();
        String output = strOp(strOps::stringReverse, input);
        System.out.println("Input string: "+input);
        System.out.println("Reverse of input is: "+output);
    }
}
