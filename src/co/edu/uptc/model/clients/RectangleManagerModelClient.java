package co.edu.uptc.model.clients;

import co.edu.uptc.pojos.MyRectangle;
import co.edu.uptc.presenter.ContractPlanes;

import java.awt.*;

public class RectangleManagerModelClient implements ContractPlanes.Model {

    private ContractPlanes.Presenter presenter;
    private MyRectangle rectangle;

    public RectangleManagerModelClient() {
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
            MyRectangle tmp = this.rectangle;
            notifyAllList();
            return tmp;
        }
    }

    public void loadRecangle(MyRectangle rectangle) {
      /*  synchronized (rectangle) {
            try {
                rectangle.wait(1);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }*/
            this.rectangle = rectangle;
        //}
    }

    private void notifyAllList() {
        synchronized (rectangle) {
            rectangle.notifyAll();
        }
    }

    public void loadInfo(){
        Client client = new Client();
        client.setInstance(this);
    }
}
