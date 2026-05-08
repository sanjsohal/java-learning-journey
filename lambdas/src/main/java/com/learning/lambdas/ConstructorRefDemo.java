package com.learning.lambdas;

public class ConstructorRefDemo {
    interface MyFunc {
        MyClass func(int n);
    }
    static class MyClass {
        private int val;
        MyClass() {
            val = 0;
        }
        MyClass(int val) {
            this.val = val;
        }
        int getVal() {
            return val;
        }
    }
    static void main() {
        MyFunc myClassCons = MyClass::new;
        MyClass myClass = myClassCons.func(3);
        System.out.println("Value is: "+myClass.getVal());
    }
}
