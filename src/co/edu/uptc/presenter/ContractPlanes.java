package co.edu.uptc.presenter;

import co.edu.uptc.model.clients.ComponentPackage;
import co.edu.uptc.pojos.MyRectangle;

import java.awt.*;

public interface ContractPlanes {

    public interface View {
        void setPresenter(Presenter presenter);
        void start();
    }

    public interface Model {
        void setPresenter(Presenter presenter);
        void rectangleCLicked(Point p);
        ComponentPackage getCurrentPoint();
        void initRecive();
    }

    public interface Presenter {
        void setView(View view);
        void setModel(Model model);
        void rectangleCLicked(Point p);
        ComponentPackage getCurrentPoint();
    }
}