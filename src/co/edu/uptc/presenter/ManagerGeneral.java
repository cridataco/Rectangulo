package co.edu.uptc.presenter;

import co.edu.uptc.Globals.Global;
import co.edu.uptc.model.clients.RectangleManagerModelClient;
import co.edu.uptc.model.server.ModelServer;
import co.edu.uptc.views.PrincipalFrame;

public class ManagerGeneral {
    ContractSocket.View view;
    ContractSocket.Model modelPlanes;
    private ContractSocket.ModelServer modelServer;
    ContractSocket.Presenter presenter;

    private void createMVP() {
        view = new PrincipalFrame();
        if (Global.whoAmI.equals("client")) {
            modelPlanes = new RectangleManagerModelClient();
            presenter = new Presenter();
            presenter.setModel(modelPlanes);
            view.setPresenter(presenter);
            modelPlanes.setPresenter(presenter);
            presenter.setView(view);
        }
        if (Global.whoAmI.equals("server")){
            modelServer = new ModelServer();
            presenter = new Presenter();
            presenter.setServerModel(modelServer);
            view.setPresenter(presenter);
            modelServer.setPresenter(presenter);
            presenter.setView(view);
        }

    }

    public void runProject() {
        if (Global.whoAmI.equals("client")) {
            createMVP();
            view.start();
            modelPlanes.initRecive();
        } else {
            createMVP();
            view.start();
            modelServer.start();
        }
    }
}