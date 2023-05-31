package co.edu.uptc.model.server;

import co.edu.uptc.Globals.Global;
import co.edu.uptc.model.comunications.Connection;
import com.google.gson.Gson;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private Connection connection;
    DataOutputStream dataOutputStream;
    DataInputStream dataInputStream;
    ModelServer model;
    private final List<Socket> sockets;
    private boolean isRemoved = false;

    public Server(ModelServer model) {
        this.model = model;
        this.sockets = new ArrayList<>();
        init();
        connect();
    }

    public void init(){
        connection = new Connection();
        connection.setType("server");
        connection.setPort(Global.port);
        connection.setHost(Global.host);
        connection.connectServer();
    }

    public void send(){
        if (!sockets.isEmpty()){
            String info =new Gson().toJson(model.getSquare());
            synchronized (sockets){
                for (Socket socket:sockets) {
                    try {
                        dataOutputStream = new DataOutputStream(socket.getOutputStream());
                        dataOutputStream.writeUTF(info);
                    } catch (IOException e) {
                        sockets.remove(socket);
                        isRemoved = true;
                        break;
                    }
                }
            }
        }
        if (isRemoved){
            isRemoved = false;
            send();
        }
    }

    public void connect(){
        Thread thread = new Thread(){
            @Override
            public void run() {
                while (model.isRunning){
                    try {
                        Socket socket = connection.getServerSocket().accept();
                        synchronized (sockets) {
                            sockets.add(socket);
                        }
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
            }
        };
        thread.start();
    }
}