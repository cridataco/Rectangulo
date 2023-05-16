package co.edu.uptc.pojos;

import java.awt.*;
import java.util.ArrayList;

public class Rectangle {

    private Point routeCoordenate;
    private int position = 0;

    public Rectangle() {
        routeCoordenate = new Point();
    }

    public Point getRouteCoordenate() {
        return routeCoordenate;
    }

    public void setRouteCoordenate(Point routeCoordenate) {
        this.routeCoordenate = routeCoordenate;
    }
}
