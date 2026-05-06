package com.learning.lambdas;

interface DoubleArrayNumericFunc {
    double func(double[] n) throws EmptyArrayException;
}
class EmptyArrayException extends Exception {
    EmptyArrayException() {
        super("Array Empty");
    }
}
public class LambdaExceptionDemo {
    static void main() throws EmptyArrayException {
        double[] arr = {1.0, 2.0, 3.0, 4.0};
        DoubleArrayNumericFunc average = n -> {
            double sum = 0.0;
            if(n.length == 0) throw new EmptyArrayException();
            for(int i = 0; i<n.length; i++) {
                sum+=i;
            }
            return sum/n.length;
        };

        System.out.println("Average of array is: "+average.func(arr));
        System.out.println("Average of empty array is: "+average.func(new double[0]));
    }
}
