import co.edu.uptc.Globals.Global;
import co.edu.uptc.model.clients.Client;
import co.edu.uptc.presenter.ManagerGeneral;

public class Main {
    public static void main(String[] parameters) {
        if (parameters.length == 3) {
            Global.whoAmI = parameters[0];
            Global.host = parameters[1];
            Global.port = Integer.parseInt(parameters[2]);
            ManagerGeneral managerGeneral = new ManagerGeneral();
            managerGeneral.runProject();

        }
        else {
            System.out.println("help");
            System.out.println("parameter : server / client");
            //0 = whoami 1 = host 2 = port
        }
    }
}