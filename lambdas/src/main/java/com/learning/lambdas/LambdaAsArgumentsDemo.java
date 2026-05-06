package com.learning.lambdas;

interface StrFunc {
    String func(String input);
}
public class LambdaAsArgumentsDemo {
    static String strOp(StrFunc func, String input) {
        return func.func(input);
    }
    static void main() {
        String inputStr = "This is input";
        String outputStr;
        outputStr = strOp(String::toUpperCase, inputStr);
        System.out.println("Text is changed to upper case is: "+outputStr);

        outputStr = strOp(str -> {
            var result = "";
            for(int i=0; i<str.length(); i++) {
                if(str.charAt(i) != ' ') {
                    result+=str.charAt(i);
                }
            }
            return result;
        }, inputStr);

        System.out.println("Text without spaces is: "+outputStr);

        StrFunc reverse = str -> {
            var result = "";
            for(int i=str.length()-1; i>=0; i--) {
                result+=str.charAt(i);
            }
            return result;
        };
        outputStr = strOp(reverse, inputStr);
        System.out.println("Sentence is reversed: "+outputStr);
    }
}
