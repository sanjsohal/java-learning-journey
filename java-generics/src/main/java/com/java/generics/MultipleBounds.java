package com.java.generics;

class Animal {
    void breathe() {
        System.out.println("Animal is breathing");
    }
}
interface Flyable {
    void fly();
}
interface Swimmable {
    void swim();
}
interface Runnable {
    void run();
}
class Duck extends Animal implements Flyable, Swimmable {
    public void fly() {
        System.out.println("Duck is flying");
    }
    public void swim() {
        System.out.println("Duck is Swimming");
    }
}
public class MultipleBounds {
    static <T extends Animal & Flyable & Swimmable> void performActions(T obj) {
        obj.breathe();
        obj.fly();
        obj.swim();
    }
    static void main() {
        Duck duck = new Duck();
        performActions(duck);
    }
}
