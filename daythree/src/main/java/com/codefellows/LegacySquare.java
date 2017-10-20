package com.codefellows;

public class LegacySquare {
    int x1, y1;
    int sideLength;

    public LegacySquare(int x1, int y1, int sideLength) {
        this.x1 = x1;
        this.y1 = y1;
        this.sideLength = sideLength;
    }

    public int getArea() {
        return sideLength*sideLength;
    }
}
