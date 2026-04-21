package com.java.generics;

class GenCons {
    private double val;
    <T extends Number>GenCons(T val) {
        this.val = val.doubleValue();
    }
    void display() {
        System.out.println("Value is: "+val);
    }
}
public class GenConsDemo {
    static void main() {
        GenCons intCons = new GenCons(100);
        intCons.display();

        GenCons doubleCons = new GenCons(123.3F);
        doubleCons.display();
    }
}
