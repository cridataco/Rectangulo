package co.edu.uptc.model.clients;

import co.edu.uptc.Globals.Global;
import co.edu.uptc.model.comunications.Connection;
import co.edu.uptc.pojos.MyRectangle;
import co.edu.uptc.views.PrincipalFrame;
import com.google.gson.Gson;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Client {

    Connection conn;
    DataOutputStream dataOutputStream;
    DataInputStream dataInputStream;
    private Gson gson;
    private ComponentPackage componentPackage;
    private RectangleManagerModelClient rectangleManagerModelClient;


    public Client(RectangleManagerModelClient rectangleManagerModelClient) {
        setInstance(rectangleManagerModelClient);
        gson = new Gson();
        init();
    }

    public void recive() {
        try {
            dataInputStream = new DataInputStream(conn.getSocket1().getInputStream());
            String aux = "";
            while (true) {
                aux = dataInputStream.readUTF();
                System.out.println(aux);
                componentPackage = gson.fromJson(aux, ComponentPackage.class);
                rectangleManagerModelClient.loadComponentPackage(componentPackage);
            }

        } catch (IOException e) {
            System.out.println("fin de la transmion");
            try {
                dataInputStream.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void init() {
        conn = new Connection();
        conn.setHost(Global.host);
        conn.setPort(Global.port);
        conn.setType("client");
        conn.connectServer();
    }

    public void setInstance(RectangleManagerModelClient rectangleManagerModelClient){
        this.rectangleManagerModelClient = rectangleManagerModelClient;
    }
}
