package com.java.generics;

public class OverrideDemo {
    static class Gen<T> {
        T obj;
        Gen(T obj) {
            this.obj = obj;
        }
        T getObj() {
            System.out.println("Inside gen's getObj");
            return obj;
        }
    }
    static class Gen2<T> extends Gen<T> {
        Gen2(T obj) {
            super(obj);
        }
        T getObj() {
            System.out.println("Inside Gen2's getObj");
            return obj;
        }
    }
    static void main() {
        Gen<Integer> obj = new Gen<>(23);
        Gen2<Integer> obj2 = new Gen2<>(34);
        Gen2<String> obj3 = new Gen2<>("test");
        Gen<Integer> obj4 = new Gen2<>(23);

        System.out.println(obj.getObj());
        System.out.println(obj2.getObj());
        System.out.println(obj3.getObj());
        System.out.println(obj4.getObj());
    }
}
