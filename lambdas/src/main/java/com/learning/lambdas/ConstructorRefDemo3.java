package com.learning.lambdas;

public class ConstructorRefDemo3 {
    interface MyFunc<R,T> {
        R func(T n);
    }
    static class MyClass<T> {
        private final T val;
        MyClass() {
            val = null;
        }
        MyClass(T val) {
            this.val = val;
        }
        T getVal() {
            return val;
        }
    }
    static class MyClass2 {
        private final String val;
        MyClass2() {
            val = null;
        }
        MyClass2(String val) {
            this.val = val;
        }
        String getVal() {
            return val;
        }
    }
    static <R, T> R myConstructorFactory(MyFunc<R, T> func, T val) {
        return func.func(val);
    }
    static void main() {
        MyFunc<MyClass<Double>, Double> func = MyClass::new;
        MyClass<Double> val = myConstructorFactory(func, 345.00);
        System.out.println(val.getVal());

        MyFunc<MyClass2, String> func2 = MyClass2::new;
        MyClass2 stringVal = myConstructorFactory(func2, "Testing");
        System.out.println(stringVal.getVal());
    }
}
