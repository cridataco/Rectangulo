package co.edu.uptc.pojos;

import java.awt.*;

public class MyRectangle {

    private int x;
    private int y;
    private int width;
    private int height;

    public MyRectangle(){

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWith() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "MyRectangle{" +
                "x=" + x +
                ", y=" + y +
                ", with=" + width +
                ", height=" + height +
                '}';
    }
}
