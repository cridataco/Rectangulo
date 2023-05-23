package co.edu.uptc.views;

import co.edu.uptc.model.clients.ComponentPackage;
import co.edu.uptc.utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RectanglesPrincipalPanel extends JPanel {

    private PrincipalFrame principalFrame;
    private ComponentPackage point;

    public RectanglesPrincipalPanel(PrincipalFrame principalFrame) {
        this.principalFrame = principalFrame;
        this.setLayout(new GridBagLayout());
        point = new ComponentPackage();
        planesChooser();
    }

    public void runFPSOfThePanel() {
        boolean running = true;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (running) {
                    loadPoint();
                    repaint();
                    new Utils().sleep(50);
                }
            }
        });
        thread.start();
    }

    private void loadPoint() {
        this.point = principalFrame.loadPoint();
    }

    public void paintComponent(Graphics g) {
        paintPlanes(g);
    }

    private void paintPlanes(Graphics g) {
        super.paintComponent(g);
        if(point.getPanelInformation() != null){
            g.setColor(new Color(point.getPanelInformation().getColor()));
            g.fillRect(0,0,1100, 700);
            paintLetters(g);
        }
    }

    private void paintLetters(Graphics g){
        g.setColor(new Color(point.getFigureInformation().getColor()));
        g.setFont(new Font(Font.SANS_SERIF, getFont().getStyle(), 15));
        g.drawRect(point.getFigureInformation().getRectangle().getX(), point.getFigureInformation().getRectangle().getY(), point.getFigureInformation().getRectangle().getWith(), point.getFigureInformation().getRectangle().getHeight());
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