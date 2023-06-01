package co.edu.uptc.model.clients;

import co.edu.uptc.model.parcial.ManagerInfomartion;
import co.edu.uptc.pojos.MyRectangle;
import co.edu.uptc.presenter.ContractSocket;

import java.awt.*;

public class RectangleManagerModelClient implements ContractSocket.Model {

    private ContractSocket.Presenter presenter;
    private ComponentPackage componentPackage;
    private ManagerInfomartion managerInfomartion;
    private Client client;

    public RectangleManagerModelClient() {
        managerInfomartion = new ManagerInfomartion();
        loadInfo();
    }

    @Override
    public void setPresenter(ContractSocket.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void rectangleCLicked(Point p) {
        synchronized (managerInfomartion) {
            try {
                managerInfomartion.wait(1);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
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

    public void loadComponentPackage(ManagerInfomartion managerInfomartion){
        this.managerInfomartion = managerInfomartion;
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
        client.getInfo();
    }

    @Override
    public ManagerInfomartion getInformation() {
        return managerInfomartion;
    }
}
