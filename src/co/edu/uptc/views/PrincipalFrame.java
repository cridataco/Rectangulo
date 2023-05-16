package co.edu.uptc.views;

import co.edu.uptc.presenter.ContractPlanes;
import javax.swing.*;
import java.awt.*;

public class PrincipalFrame extends JFrame implements ContractPlanes.View {

    ContractPlanes.Presenter presenter;
    private PlanesPrincipalPanel planesPanel;

    public PrincipalFrame() {
        super("Sistema de facturadora");
        this.setSize(1100, 700);
        initPanels();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        start();
    }

    private void initPanels() {
        planesPanel = new PlanesPrincipalPanel(this);
        this.add(planesPanel);
        planesPanel.setVisible(true);
    }

    @Override
    public void setPresenter(ContractPlanes.Presenter presenter) {
        this.presenter = presenter;
        planesPanel.runFPSOfThePanel();
    }

    public void rectangleCLicked(Point point){
        presenter.rectangleCLicked(point);
    }

    public Point loadPoint() {
        return presenter.getCurrentPoint();
    }

    @Override
    public void start() {
        this.setVisible(true);
    }
}