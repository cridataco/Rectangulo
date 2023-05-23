package co.edu.uptc.model.clients;

import co.edu.uptc.pojos.MyRectangle;

public class FigureInformation {

    private MyRectangle rectangle;
    private int Color;

    public FigureInformation(){

    }

    public MyRectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(MyRectangle rectangle) {
        this.rectangle = rectangle;
    }

    public int getColor() {
        return Color;
    }
}
