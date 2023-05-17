package co.edu.uptc.model.clients;

import co.edu.uptc.pojos.MyRectangle;
import co.edu.uptc.presenter.ContractPlanes;

import java.awt.*;

public class RectangleManagerModel implements ContractPlanes.Model {

    private ContractPlanes.Presenter presenter;
    private MyRectangle rectangle;

    public RectangleManagerModel(){
        rectangle = new MyRectangle();
    }

    @Override
    public void setPresenter(ContractPlanes.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void rectangleCLicked(Point p) {
        synchronized (rectangle) {
            try {
                rectangle.wait(1);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            rectangle.setX(p.x);
            rectangle.setY(p.y);
            notifyAllList();
        }
    }

    @Override
    public MyRectangle getCurrentPoint() {
        synchronized (rectangle) {
            try {
                rectangle.wait(1);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            MyRectangle tmp = rectangle;
            notifyAllList();
            return tmp;
        }
    }

    private void notifyAllList() {
        synchronized (rectangle) {
            rectangle.notifyAll();
        }
    }
}
