package co.edu.uptc.model.clients;

import co.edu.uptc.pojos.MyRectangle;

public class BytesMapper {

    private int number;
    private MyRectangle rectangle;

    public BytesMapper() {
        rectangle = new MyRectangle();
    }

    public void setNumber(int numero){
        this.number = numero;
    }

    public int getOneNumber() {
        return number >>> 22;
    }

    public int getTwoNumber() {
        int mascara = (1 << 10) - 1;
        return (number >>> 12) & mascara;
    }

    public int getTherdNumber() {
        int mascara = (1 << 6) - 1;
        return (number >>> 6) & mascara;
    }

    public int getFourNumber() {
        int mascara = (1 << 6) - 1;
        return number & mascara;
    }

    private MyRectangle converRetangle(){
        MyRectangle myRectangle = rectangle;
        myRectangle.setX(getOneNumber());
        myRectangle.setY(getTwoNumber());
        myRectangle.setHeight(getTherdNumber());
        myRectangle.setWidth(getFourNumber());
        return myRectangle;
    }

    public MyRectangle getRectangle(int number){
        setNumber(number);
        return converRetangle();
    }
}
