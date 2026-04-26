package com.java.generics;

public class HierDemo5 {
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
        Gen2(T o) {
            super(o);
        }
    }
    static void main() {
        var iob = new Gen<Integer>(23);
        var strObj2 = new Gen2<String>("hello");
        Gen2<Integer> iob2 = new Gen2<>(33);

        if(iob instanceof Gen<?>) System.out.println("iob is instance of Gen");

        if(strObj2 instanceof Gen2<?>) System.out.println("strObj2 is instance of Gen2");

        if(strObj2 instanceof Gen<?>) System.out.println("strObj2 is instance of Gen");

        if(iob instanceof Gen2<?>) System.out.println("iob is instance of Gen2");

        if(iob2 instanceof Gen2<Integer>) System.out.println("iob2 is instance of Gen2<Integer>");
    }
}
