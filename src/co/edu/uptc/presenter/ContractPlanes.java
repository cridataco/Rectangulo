package co.edu.uptc.presenter;

import java.awt.*;
import java.util.ArrayList;

public interface ContractPlanes {

    public interface View {
        void setPresenter(Presenter presenter);
        void start();
    }

    public interface Model {
        void setPresenter(Presenter presenter);
        void rectangleCLicked(Point p);
        Point getCurrentPoint();
    }

    public interface Presenter {
        void setView(View view);
        void setModel(Model model);
        void rectangleCLicked(Point p);
        Point getCurrentPoint();
    }
}