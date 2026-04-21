package com.java.generics;

import java.util.ArrayList;
import java.util.List;

public class BoundExercise {
    static void main() {
        System.out.println(sumList(List.of(1, 2, 3)));           // integers
        System.out.println(sumList(List.of(1.5, 2.5)));          // doubles
        System.out.println(sumList(List.of(1.1f, 2.2f)));        // floats
        List<Integer> ints   = new ArrayList<>();
        List<Number>  nums   = new ArrayList<>();
        List<Object>  objs   = new ArrayList<>();
        fillWithValues(ints, 3);
        fillWithValues(nums, 3);
        fillWithValues(objs, 3);
        System.out.println("Integer list: "+ints);
        System.out.println("Number list: "+nums);
        System.out.println("Object list: "+objs);
        printAll(List.of("a", "b", "c"));
        printAll(List.of(1, 2, 3));
        printAll(List.of(new Object()));
        List<Number> dest = new ArrayList<>();
        List<Integer> src = List.of(1, 2, 3);
        copyItems(dest, src);
        System.out.println("Destination list: "+dest);
    }
    public static double sumList(List<? extends Number> list) {
        double sum = 0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }
    public static void fillWithValues(List<? super Integer> list, int count) {
        for (int i = 1; i <= count; i++) {
            list.add(i);
        }
    }
    public static void printAll(List<?> list) {
        for(Object element:list) {
            System.out.println(element);
        }
    }
    public static <T> void copyItems(
            List<? super Number> dest,
            List<? extends Number> src
    ) {
        for (Number item : src) {
            dest.add(item);
        }
    }

}
