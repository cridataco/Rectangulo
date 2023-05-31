package co.edu.uptc.model.comunications;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Connection {

    protected ServerSocket serverSocket;
    protected Socket socket1;
    private String type;
    private String host;
    private int port;

    public Connection() {
    }

    public void connectServer() {
        try {
            switch (type) {
                case "client": {
                    socket1 = new Socket(host, port);
                    break;
                }
                case "server": {
                    serverSocket = new ServerSocket(port);
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void send(String value){
    }

    public String recive(String value){
        return value;
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public Socket getSocket1() {
        return socket1;
    }

    public void setSocket1(Socket socket1) {
        this.socket1 = socket1;
    }
}
