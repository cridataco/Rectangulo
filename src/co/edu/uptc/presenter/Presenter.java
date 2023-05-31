package co.edu.uptc.presenter;

import co.edu.uptc.model.clients.ComponentPackage;
import java.awt.*;

public class Presenter implements ContractSocket.Presenter {

    private ContractSocket.View view;
    private ContractSocket.Model model;
    private ContractSocket.ModelServer modelServer;

    @Override
    public void setView(ContractSocket.View view) {
        this.view = view;
    }

    @Override
    public void setModel(ContractSocket.Model model) {
        this.model = model;
    }

    @Override
    public void setServerModel(ContractSocket.ModelServer models) {
        this.modelServer = models;
    }

    @Override
    public void rectangleCLicked(Point p) {
        model.rectangleCLicked(p);
    }

    @Override
    public ComponentPackage getCurrentPoint() {
        return null;//model.getCurrentPoint();
    }
}