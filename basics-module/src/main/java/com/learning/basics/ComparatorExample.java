package com.learning.basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparatorExample {
    static class Employee implements Comparator<Employee> {
        private int id;
        private String name;
        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.id - o2.id;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
    static void main() {
        Employee e1 = new Employee(1, "Sajinder");
        Employee e2 = new Employee(2, "Aman");
        Employee e3 = new Employee(3, "Michael");
        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        Collections.sort(employees, Comparator.comparing(Employee::getName));
    }
}
