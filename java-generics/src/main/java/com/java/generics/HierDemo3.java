package com.java.generics;

public class HierDemo3 {
    static class NumGen {
        int i;
        NumGen(int i) {
            this.i = i;
        }
        int getNumbObj() {
            return i;
        }
    }
    static class Gen<T> extends NumGen {
        T obj;
        Gen(T obj, int i) {
            super(i);
            this.obj = obj;
        }
        T getObj() {
            return obj;
        }
    }
    static void main() {
        Gen<String> obj = new Gen<>("test", 2);
        System.out.println(obj.getNumbObj());
        System.out.println(obj.getObj());
    }
}
