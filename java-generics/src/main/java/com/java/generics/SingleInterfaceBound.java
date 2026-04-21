package com.java.generics;

interface Drawable {
    void draw();
}
class Circle implements Drawable {
    public void draw() {
        System.out.println("Circle is drawn");
    }
}
class Square implements Drawable {
    public void draw() {
        System.out.println("Square id drawn");
    }
}
class Rectangle implements Drawable {
    public void draw() {
        System.out.println("Rectangle is drawn");
    }
}

public class SingleInterfaceBound {
    static <T extends Drawable> void render(T obj) {
        obj.draw();
    }
    static void main() {
        render(new Circle());
        render(new Rectangle());
        render(new Square());
    }
}
