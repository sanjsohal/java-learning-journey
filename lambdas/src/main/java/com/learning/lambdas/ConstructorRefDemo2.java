package com.learning.lambdas;

public class ConstructorRefDemo2 {
    interface MyFunc<T> {
        MyClass<T> func(T n);
    }

    static class MyClass<T> {
        private final T val;
        MyClass(T val) {
            this.val = val;
        }
        T getVal() {
            return val;
        }
    }
    static void main() {
        MyFunc<Double> func = MyClass::new;
        MyClass<Double> val = func.func(345.00);
        System.out.println(val.getVal());
    }
}
