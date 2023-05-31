package co.edu.uptc.model.server;

import co.edu.uptc.presenter.ContractSocket;

import java.awt.*;

public class ModelServer implements ContractSocket.ModelServer {
    ContractSocket.Presenter presenter;
    private final Rectangle rectangle;
    boolean isRunning = true;
    private Server server;

    public ModelServer() {
        rectangle = new Rectangle(0,0,100,100);
    }

    @Override
    public void setPresenter(ContractSocket.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void moveSquare(int x, int y) {
        rectangle.setLocation(x,y);
        server.send();
    }

    @Override
    public Rectangle getSquare() {
        return (Rectangle) rectangle.clone();
    }

    @Override
    public void terminate() {
        isRunning = false;
    }

    @Override
    public void start() {
        server = new Server(this);
    }
}
