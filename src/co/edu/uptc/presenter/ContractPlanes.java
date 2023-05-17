package co.edu.uptc.presenter;

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
        MyRectangle getCurrentPoint();
    }

    public interface Presenter {
        void setView(View view);
        void setModel(Model model);
        void rectangleCLicked(Point p);
        MyRectangle getCurrentPoint();
    }
}