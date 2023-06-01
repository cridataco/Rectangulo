package co.edu.uptc.views;

import co.edu.uptc.model.clients.ComponentPackage;
import co.edu.uptc.model.parcial.ManagerInfomartion;
import co.edu.uptc.pojos.MyRectangle;
import co.edu.uptc.presenter.ContractSocket;
import javax.swing.*;
import java.awt.*;

public class PrincipalFrame extends JFrame implements ContractSocket.View {

    ContractSocket.Presenter presenter;
    private RectanglesPrincipalPanel planesPanel;

    public PrincipalFrame() {
        super("Cliente Servidor");
        this.setSize(1100, 700);
        initPanels();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        start();
    }

    private void initPanels() {
        planesPanel = new RectanglesPrincipalPanel(this);
        this.add(planesPanel);
        planesPanel.setVisible(true);
    }

    @Override
    public void setPresenter(ContractSocket.Presenter presenter) {
        this.presenter = presenter;
        planesPanel.runFPSOfThePanel();

    }

    public void rectangleCLicked(Point point){
        presenter.rectangleCLicked(point);
    }

    public ComponentPackage loadPoint() {
        return presenter.getCurrentPoint();
    }

    public void setRectangle(MyRectangle myRectangle){

    }

    public ManagerInfomartion getInformation(){
        ManagerInfomartion managerInfomartion = presenter.getInformation();
        if(managerInfomartion.getFrameInformation() != null) {
            this.setSize(new Dimension(managerInfomartion.getFrameInformation().getWidth(), managerInfomartion.getFrameInformation().getHeight()));
            this.setLocation(managerInfomartion.getFrameInformation().getX(), managerInfomartion.getFrameInformation().getY());
        }
        return managerInfomartion;
    }

    @Override
    public void start() {
        this.setVisible(true);
    }
}