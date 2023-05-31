package co.edu.uptc.presenter;

import co.edu.uptc.model.clients.ComponentPackage;

import java.awt.*;

public interface ContractSocket {

    interface View {
        void setPresenter(Presenter presenter);
        void start();
    }

    interface Model {
        void setPresenter(Presenter presenter);
        void rectangleCLicked(Point p);
        ComponentPackage getCurrentPoint();
        void initRecive();
    }

    interface ModelServer{
        void setPresenter(ContractSocket.Presenter presenter);
        void moveSquare(int x, int y);
        void terminate();
        Rectangle getSquare();
        void start();
    }

    interface Presenter {
        void setView(View view);
        void setModel(Model model);
        void setServerModel(ModelServer model);
        void rectangleCLicked(Point p);
        ComponentPackage getCurrentPoint();
    }
}