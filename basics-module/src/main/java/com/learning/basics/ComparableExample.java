package com.learning.basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableExample {
    static class Employee implements Comparable<Employee> {
        private int id;
        private String name;
        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }
        public int compareTo(Employee other) {
            return Integer.compare(this.id, other.id);
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
    static void main(){
        Employee e1 = new Employee(1, "Sajinder");
        Employee e2 = new Employee(2, "Aman");
        Employee e3 = new Employee(3, "Michael");
        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        Collections.sort(employees);
        System.out.println(employees);
    }
}
