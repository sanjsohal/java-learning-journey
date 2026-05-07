package com.learning.lambdas;

public class MethodRefDemo3 {

    interface TwoArgFunc {
        String apply(Person p, String greeting);
    }

    static class Person {
        String name;

        Person(String name) {
            this.name = name;
        }

        // instance method — takes ONE parameter
        String greet(String greeting) {
            return greeting + ", " + name + "!";
        }
    }

    static void main() {

        // 1. Normal call — nothing special
        Person alice = new Person("Alice");
        System.out.println(alice.greet("Hello"));
        // Output: Hello, Alice!

        // 2. Method reference via CLASS name
        //    greet() takes 1 param, but ClassName::method adds the receiver
        //    so it matches TwoArgFunc (2 params)
        TwoArgFunc func = Person::greet;

        // func.apply(person, greeting) → person.greet(greeting)
        Person bob = new Person("Bob");
        System.out.println(func.apply(bob, "Hey"));
        // Output: Hey, Bob!

        System.out.println(func.apply(alice, "Hi"));
        // Output: Hi, Alice!

        // 3. Compare: method reference via OBJECT
        //    Receiver is already fixed to alice, so only 1 param needed
        //    This would NOT match TwoArgFunc
        // TwoArgFunc func2 = alice::greet;  // COMPILE ERROR!
    }
}
