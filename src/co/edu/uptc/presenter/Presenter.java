package co.edu.uptc.presenter;

import co.edu.uptc.model.clients.ComponentPackage;
import co.edu.uptc.pojos.MyRectangle;

import java.awt.*;
import java.util.ArrayList;

public class Presenter implements ContractPlanes.Presenter {

    private ContractPlanes.View view;
    private ContractPlanes.Model model;

    @Override
    public void setView(ContractPlanes.View view) {
        this.view = view;
    }

    @Override
    public void setModel(ContractPlanes.Model model) {
        this.model = model;
    }

    @Override
    public void rectangleCLicked(Point p) {
        model.rectangleCLicked(p);
    }

    @Override
    public ComponentPackage getCurrentPoint() {
        return model.getCurrentPoint();
    }

}