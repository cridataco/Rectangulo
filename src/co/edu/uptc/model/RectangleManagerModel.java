package co.edu.uptc.model;

import co.edu.uptc.pojos.Rectangle;
import co.edu.uptc.presenter.ContractPlanes;

import java.awt.*;

public class RectangleManagerModel implements ContractPlanes.Model {

    private ContractPlanes.Presenter presenter;
    private Rectangle rectangle;

    public RectangleManagerModel(){
        rectangle = new Rectangle();
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
            rectangle.setRouteCoordenate(p);
            notifyAllList();
        }
    }

    @Override
    public Point getCurrentPoint() {
        synchronized (rectangle) {
            try {
                rectangle.wait(1);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            Point tmp = rectangle.getRouteCoordenate();
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
