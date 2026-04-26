package com.java.generics;

public class HierDemo2 {
    static class Gen<T> {
        T obj;
        Gen(T o) {
            obj = o;
        }
        T getObj() {
            return obj;
        }
    }
    static class Gen2<T, V> extends Gen<T> {
        V obj2;
        Gen2(T obj, V obj2) {
            super(obj);
            this.obj2 = obj2;
        }
        V getObj2() {
            return obj2;
        }
    }
    static void main() {
        Gen2<String, Integer> gen2Obj = new Gen2<>("test", 23);
        System.out.println(gen2Obj.getObj());
        System.out.println(gen2Obj.getObj2());
    }
}
