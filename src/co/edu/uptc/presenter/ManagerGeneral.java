package co.edu.uptc.presenter;

import co.edu.uptc.Globals.Global;
import co.edu.uptc.model.clients.RectangleManagerModelClient;
import co.edu.uptc.views.PrincipalFrame;

public class ManagerGeneral {
    ContractPlanes.View view;
    ContractPlanes.Model modelPlanes;
    ContractPlanes.Presenter presenter;

    private void createMVP() {
        view = new PrincipalFrame();
        if (Global.whoAmI.equals("client")) {
            modelPlanes = new RectangleManagerModelClient();
        }
        //if{
    //    modelPlanes = new RectangleManagerModelSErver();
    //}
        presenter = new Presenter();
        view.setPresenter(presenter);
        modelPlanes.setPresenter(presenter);
        presenter.setView(view);
        presenter.setModel(modelPlanes);
    }

    public void runProject() {
        System.out.println("entra 1");
        createMVP();
        System.out.println("entro");
        view.start();
        modelPlanes.initRecive();
    }
}