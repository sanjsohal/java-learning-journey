package com.java.generics;

public class HierDemo4 {
    static class Gen<T> {
        T obj;
        Gen(T o) {
            obj = o;
        }
        T getObj() {
            return obj;
        }
    }
    static class GenInteger extends Gen<Integer> {
        GenInteger(Integer obj) {
            super(obj);
        }
    }
    static void main() {
        Gen<String> strObj = new Gen<>("test2");
        System.out.println(strObj.getObj());

        GenInteger intObj = new GenInteger(233);
        System.out.println(intObj.getObj());
    }
}
