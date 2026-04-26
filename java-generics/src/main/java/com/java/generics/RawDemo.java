package com.java.generics;

public class RawDemo {
    static class Gen<T> {
        T obj;
        Gen(T obj) {
            this.obj = obj;
        }
        T getObj() {
            return obj;
        }
    }
    static void main() {
        Gen<Integer> iob = new Gen<>(23);
        System.out.println(iob.getObj());

        Gen<String> strObj = new Gen<>("test");
        System.out.println(strObj.getObj());

        Gen raw = new Gen(Double.valueOf(23));
        double d = (Double) raw.getObj();

       // int i = (Integer)raw.getObj(); //This throws exception that Double cannot be cast to Integer

        strObj = raw;
        //String str = strObj.getObj(); //Double cannot be cast to String

        raw = iob;
        //d = (Double)raw.getObj(); //Integer cannot be cast to Double


    }
}
