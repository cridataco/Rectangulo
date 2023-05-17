package co.edu.uptc.presenter;

import co.edu.uptc.model.clients.RectangleManagerModel;
import co.edu.uptc.views.PrincipalFrame;

public class ManagerGeneral {
    ContractPlanes.View view;
    ContractPlanes.Model modelPlanes;
    ContractPlanes.Presenter presenter;

    private void createMVP() {
        view = new PrincipalFrame();
        modelPlanes = new RectangleManagerModel();
        presenter = new Presenter();
        view.setPresenter(presenter);
        modelPlanes.setPresenter(presenter);
        presenter.setView(view);
        presenter.setModel(modelPlanes);
    }

    public void runProject() {
        createMVP();
        view.start();
    }
}