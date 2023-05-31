package co.edu.uptc.model.clients;

import co.edu.uptc.pojos.MyRectangle;
import co.edu.uptc.presenter.ContractSocket;

import java.awt.*;

public class RectangleManagerModelClient implements ContractSocket.Model {

    private ContractSocket.Presenter presenter;
    private ComponentPackage componentPackage;
    private Client client;

    public RectangleManagerModelClient() {
        componentPackage = new ComponentPackage();
        loadInfo();
    }

    @Override
    public void setPresenter(ContractSocket.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void rectangleCLicked(Point p) {
        synchronized (componentPackage) {
            try {
                componentPackage.wait(1);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            /*componentPackage.getFigureInformation().getRectangle().setX(p.x);
            componentPackage.getFigureInformation().getRectangle().setY(p.y);*/
            notifyAllList();
        }
    }

    @Override
    public ComponentPackage getCurrentPoint() {
        synchronized (componentPackage) {
            try {
                componentPackage.wait(1);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            ComponentPackage tmp = this.componentPackage;
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
           // this.rectangle = rectangle;
        //}
    }

    public void loadComponentPackage(ComponentPackage componentPackage){
        this.componentPackage = componentPackage;
    }

    private void notifyAllList() {
        synchronized (componentPackage) {
            componentPackage.notifyAll();
        }
    }

    public void loadInfo(){
        client = new Client(this);
    }

    public void initRecive(){
        client.recive();
    }
}
