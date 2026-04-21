package com.learning.basics;
class Address {
    String city;

    Address(String city) {
        this.city = city;
    }
}

class Person {
    String name;
    Address address;

    // Constructor accepting user-defined type
    Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    void display() {
        System.out.println(name + " lives in " + address.city);
    }
}

public class Main {
    static void main() {
        Address addr = new Address("Delhi");
        Person p = new Person("Rahul", addr);

        p.display();
        addr = new Address("Mumbai");
        p.display();
    }
}
