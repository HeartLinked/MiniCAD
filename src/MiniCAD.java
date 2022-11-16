import Controller.controller;
import Model.model;
import View.view;

public class MiniCAD {
    public static void main(String[] args) {
        view view = new view();
        model model = new model();
        controller controller = new controller(view, model);
    }
}