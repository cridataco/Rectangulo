package co.edu.uptc.model.server;

import co.edu.uptc.Globals.Global;
import co.edu.uptc.model.comunications.Connection;

import java.net.Socket;
import java.util.ArrayList;

public class Server {

    private Connection conn;
    private ArrayList<Socket> sockets;
    private int x;
    private int y;
    private int id;


    public Server() {
        sockets = new ArrayList<>();
        x = 0;
        y = 0;
        init();
    }

    public void init() {
        conn = new Connection();
        conn.setHost(Global.host);
        conn.setPort(Global.port);
        conn.setType("server");
        conn.connectServer();
    }

    public int getX() {
        if(x > 300){
            x = 0;
        } else {
            x++;
        }
        return x;
    }

    public int getY() {
        if(y > 300){
            y = 0;
        } else {
            y++;
        }
        return y;
    }
}
