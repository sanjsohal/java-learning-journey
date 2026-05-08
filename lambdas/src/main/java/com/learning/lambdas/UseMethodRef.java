package com.learning.lambdas;

import java.util.ArrayList;
import java.util.Collections;

public class UseMethodRef {
    static class MyClass {
        private int val;
        MyClass(int val) {
            this.val = val;
        }
        int getVal() {
            return val;
        }
    }
    static int compareMC(MyClass m1, MyClass m2) {
        return m1.getVal()-m2.getVal();
    }
    static void main() {
        ArrayList<MyClass> al = new ArrayList<>();
        al.add(new MyClass(1));
        al.add(new MyClass(4));
        al.add(new MyClass(2));
        al.add(new MyClass(9));
        al.add(new MyClass(3));
        al.add(new MyClass(7));

        MyClass maxValueObj = Collections.max(al, UseMethodRef::compareMC);
        System.out.println("Maximum value is: "+maxValueObj.getVal());
    }
}
