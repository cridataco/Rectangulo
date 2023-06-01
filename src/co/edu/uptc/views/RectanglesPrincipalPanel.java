package co.edu.uptc.views;

import co.edu.uptc.model.clients.BytesMapper;
import co.edu.uptc.model.clients.ComponentPackage;
import co.edu.uptc.model.parcial.ManagerInfomartion;
import co.edu.uptc.pojos.MyRectangle;
import co.edu.uptc.utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RectanglesPrincipalPanel extends JPanel {

    private PrincipalFrame principalFrame;
    private ComponentPackage point;
    private ManagerInfomartion information;
    private BytesMapper bytesMapper;
    private MyRectangle rectangle;

    public RectanglesPrincipalPanel(PrincipalFrame principalFrame) {
        this.principalFrame = principalFrame;
        this.setLayout(new GridBagLayout());
        point = new ComponentPackage();
        information = new ManagerInfomartion();
        bytesMapper = new BytesMapper();
        planesChooser();
    }

    public void runFPSOfThePanel() {
        boolean running = true;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (running) {
                    if(information != null) {
                        loadPoint();
                    }
                    //System.out.println(bytesMapper.getOneNumber());
                    repaint();
                    new Utils().sleep(50);
                }
            }
        });
        thread.start();
    }

    private void loadPoint() {
            this.information = principalFrame.getInformation();
            if(this.information.getFigureInformation() != null) {
                bytesMapper.setNumber(information.getFigureInformation().getRectangle());
            }
        //rectangle = bytesMapper.getRectangle(point.getFigureInformation().getColor());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(information.getPanelInformation() != null) {
            g.setColor(new Color(information.getPanelInformation().getColor()));
        }
        if(information.getFigureInformation() != null) {
             g.drawRect(bytesMapper.getOneNumber(), bytesMapper.getTwoNumber(), bytesMapper.getTherdNumber(), bytesMapper.getFourNumber());
        }
    }

    private void planesChooser() {
        final Point[] planeChoosed = {null};
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
            }
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                planeChoosed[0] = mouseEvent.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {}
            @Override
            public void mouseEntered(MouseEvent mouseEvent) {}
            @Override
            public void mouseExited(MouseEvent mouseEvent) {}
        });
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {
                if (planeChoosed[0] != null) {
                    principalFrame.rectangleCLicked(mouseEvent.getPoint());
                }
            }
            @Override
            public void mouseMoved(MouseEvent mouseEvent) {}
        });
    }
}