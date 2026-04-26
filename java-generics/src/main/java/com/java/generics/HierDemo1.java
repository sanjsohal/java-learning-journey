package com.java.generics;

public class HierDemo1 {
    static class Gen<T> {
        T obj;
        Gen(T o) {
            obj = o;
        }
        T getObj() {
            return obj;
        }
    }
    static class Gen2<T> extends Gen<T> {
        Gen2(T obj) {
            super(obj);
        }
    }
    static void main() {
        Gen2<String> strObj = new Gen2<>("test");
        System.out.println(strObj.getObj());
    }
}
