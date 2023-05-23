package co.edu.uptc.model.server;

import co.edu.uptc.Globals.Global;
import co.edu.uptc.pojos.MyRectangle;
import com.google.gson.Gson;

public class Socket {

    private Socket socket;
    private int id;
    private boolean working;
    private Server myServer;

    public Socket(Server server, int id){
        this.id = id;
        working = true;
        this.myServer = server;
        sendInformation();
    }

    public void sendInformation(){
        Gson gson = new Gson();
        MyRectangle tmpRectangle = new MyRectangle();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (working){
                    String json = gson.toJson(MyRectangle.class);
                    createRectangle(tmpRectangle);
                    //enviar el json con tmpRectangle  outputStream.write(json.getBytes());
                }
            }
        });
    }

    private void createRectangle(MyRectangle rectangle){
        rectangle.setHeight(Global.HEIGHT);
        rectangle.setHeight(Global.WEIGHT);
        rectangle.setX(myServer.getX());
        rectangle.setX(myServer.getY());
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
