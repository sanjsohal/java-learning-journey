package com.java.generics;

import java.util.function.Function;

class Pair<A, B> {
    A first;
    B second;
    Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }
    A getFirst() {
        return first;
    }
    B getSecond() {
        return second;
    }
    Pair<B,A> swap() {
        return new Pair<>(second, first);
    }
    <C>Pair<C,B> mapFirst(Function<A, C> f) {
        return new Pair<>(f.apply(first), second);
    }
    static <A, B>Pair<A, B> of(A first, B second) {
        return new Pair<>(first, second);
    }
}
public class PairDemo {
    static void main() {
        // Step 1: Create Pair<String, Integer>
        Pair<String, Integer> p1 = Pair.of("hello", 42);
        System.out.println("Original: (" + p1.getFirst() + ", " + p1.getSecond() + ")");

        // Step 2: mapFirst - Pair<String, Integer> → Pair<Integer, Integer>
        Pair<Integer, Integer> p2 = p1.mapFirst(String::length);
        System.out.println("After mapFirst: (" + p2.getFirst() + ", " + p2.getSecond() + ")");

        // Step 3: swap - Pair<Integer, Integer> → Pair<Integer, Integer>
        Pair<Integer, Integer> p3 = p2.swap();
        System.out.println("After swap: (" + p3.getFirst() + ", " + p3.getSecond() + ")");
    }
}
