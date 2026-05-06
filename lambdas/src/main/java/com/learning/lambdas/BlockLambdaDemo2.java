package com.learning.lambdas;

interface StringFunc {
    String reverse(String input);
}
public class BlockLambdaDemo2 {
    static void main() {
        StringFunc rev = str -> {
            String result = "";
            for(int i = str.length()-1; i>=0; i--) {
                result+=str.charAt(i);
            }
            return result;
        };
        System.out.println("Reversing Lambda: "+rev.reverse("Lambda"));
        System.out.println("Reversing Hello: "+rev.reverse("Hello"));
    }
}
