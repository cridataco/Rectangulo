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

    public static int extraerBits(int numero, int posicion, int numBits) {
        int mascara = (1 << numBits) - 1;  // Crear la máscara de bits
        int resultado = (numero >> posicion) & mascara;  // Aplicar la máscara y desplazamiento
        return resultado;
    }










   /* numero: Es el número entero del cual deseas extraer los bits.

    posicion: Es la posición desde la cual deseas extraer los bits. La posición más baja es 0, que es el bit menos significativo.

    numBits: Es el número de bits que deseas extraer.*/
}
