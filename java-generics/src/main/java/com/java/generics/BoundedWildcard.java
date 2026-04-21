package com.java.generics;

class TwoD {
    int x;
    int y;
    TwoD(int x, int y) {
        this.x = x;
        this.y =  y;
    }
}
class ThreeD extends TwoD {
    int z;
    ThreeD(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
}
class FourD extends ThreeD {
    int t;
    FourD(int x, int y, int z, int t) {
        super(x, y, z);
        this.t = t;
    }
}
class Coords<T extends TwoD> {
    T[] coords;
    Coords(T[] coords) {
        this.coords = coords;
    }
}
public class BoundedWildcard {
    static void showXY(Coords<? extends TwoD> obj) {
        System.out.println("TwoD coordinates are: ");
        for(int i = 0; i<obj.coords.length; i++) {
            System.out.println("x: "+obj.coords[i].x+", y: "+obj.coords[i].y);
        }
    }
    static void showXYZ(Coords<? extends ThreeD> obj) {
        System.out.println("ThreeD coordinates are: ");
        for(int i = 0; i<obj.coords.length; i++) {
            System.out.println("x: "+obj.coords[i].x+", y: "+obj.coords[i].y+", z: "+obj.coords[i].z);
        }
    }
    static void showXYZT(Coords<? extends FourD> obj) {
        System.out.println("FourD coordinates are: ");
        for(int i = 0; i<obj.coords.length; i++) {
            System.out.println("x: "+obj.coords[i].x+", y: "+obj.coords[i].y+", z: "+obj.coords[i].z+", t: "+obj.coords[i].t);
        }
    }
    static void main() {
        TwoD[] twoDs = new TwoD[] {
                new TwoD(2, 3),
                new TwoD(1, 4),
                new TwoD(3,5),
                new TwoD(4, 6)
        };
        ThreeD[] threeDs = new ThreeD[] {
                new ThreeD(2, 3, 4),
                new ThreeD(1, 4, 5),
                new ThreeD(3,5, 6),
                new ThreeD(4, 6, 7)
        };
        FourD[] fourDs = new FourD[] {
                new FourD(2, 3, 4, 5),
                new FourD(1, 4, 5, 6),
                new FourD(3, 5, 6, 7),
                new FourD(4, 6, 7, 8)
        };
        Coords<TwoD> twoDCoords = new Coords<>(twoDs);
        Coords<ThreeD> threeDCoords = new Coords<>(threeDs);
        Coords<FourD> fourDCoords = new Coords<>(fourDs);
        showXY(twoDCoords);
        showXYZ(threeDCoords);
        showXYZT(fourDCoords);
    }
}
