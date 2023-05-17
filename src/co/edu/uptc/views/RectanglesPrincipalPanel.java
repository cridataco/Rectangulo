package co.edu.uptc.views;

import co.edu.uptc.Globals.Global;
import co.edu.uptc.pojos.MyRectangle;
import co.edu.uptc.utils.Utils;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class RectanglesPrincipalPanel extends JPanel {

    private PrincipalFrame principalFrame;
    private MyRectangle point;

    public RectanglesPrincipalPanel(PrincipalFrame principalFrame) {
        this.principalFrame = principalFrame;
        this.setLayout(new GridBagLayout());
        point = new MyRectangle();
        planesChooser();
    }

    private void addPlane(Graphics g, Image image, int xPosition, int yPosition) {
        xPosition = xPosition - (Global.WIDTH / 2);
        yPosition = yPosition - (Global.HEIGHT / 2);
        g.drawImage(image, xPosition, yPosition, this);
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
        g.setColor(new Color(230, 100, 100));
        super.paintComponent(g);
        paintLetters(g);
    }

    private void paintLetters(Graphics g){
        g.setFont(new Font(Font.SANS_SERIF, getFont().getStyle(), 15));
        g.drawRect(point.getX(), point.getY(), 200, 200);
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