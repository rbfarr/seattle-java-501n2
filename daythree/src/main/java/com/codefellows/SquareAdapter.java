package com.codefellows;

public class SquareAdapter {
    int x1, y1;
    int x2, y2;

    private LegacySquare ls;

    public SquareAdapter(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

        ls = new LegacySquare(x1, y1, Math.abs(x1-x2));
    }

    public int getArea() {
        return ls.getArea();
    }
}
