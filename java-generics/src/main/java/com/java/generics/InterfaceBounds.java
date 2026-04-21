package com.java.generics;
interface Printable {
    void print();
}
interface Serializable {
    void serialize();
}
interface Loggable {
    void log();
}
class Report implements Printable, Serializable, Loggable {
    public void print() {
        System.out.println("Report is printing");
    }
    public void serialize() {
        System.out.println("Report is serialized");
    }
    public void log() {
        System.out.println("Report is logged");
    }
}

public class InterfaceBounds {
    static void main() {
        Report report = new Report();
        printExecution(report);
    }
    static <T extends Printable & Serializable & Loggable> void printExecution(T obj) {
        obj.print();
        obj.serialize();
        obj.log();
    }
}
