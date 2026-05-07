package com.learning.lambdas;

public class MethodRefDemo4 {
    interface ThreeArgCheck<T> {
        boolean check(T item, int min, int max);
    }
    static class Student {
        String name;
        int marks;
        Student(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }
        boolean scoredWithin(int min, int max) {
            return this.marks>=min && this.marks <=max;
        }

    }
    static int findStudents(Student[] students, ThreeArgCheck<Student> func, int min, int max) {
        var count = 0;
        for(Student student: students) {
            if(func.check(student, min, max)) count++;
        }
        return count;
    }
    static void main() {
        Student[] students = {  new Student("Alice", 75), new Student("Bob", 52),
                                new Student("Charlie", 88), new Student("Deepak", 67),
                                new Student("Eva", 80)};

        System.out.println("Number of students having marks between 60 and 80 are: "+findStudents(students, Student::scoredWithin, 60, 80));
        System.out.println("Number of students having marks between 30 and 100 are: "+findStudents(students, Student::scoredWithin, 30, 100));
    }
}
