package View;

import Controller.myController;
import Model.Shape;
import Model.myModel;

import java.awt.*;
import java.io.Serial;
import java.util.ArrayList;

import static Model.myModel.shapes;

public class MyCanvas extends Canvas {

    @Serial
    private static final long serialVersionUID = 1L;

//    ArrayList<Model.Shape> shapes = new ArrayList<>(); //暂时用来传递参数

    MyCanvas() {
        setBackground(Color.WHITE);
        addMouseListener(new myController.mouseListener());
        addMouseMotionListener(new myController.mouseListener());
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(!shapes.isEmpty()) {
            for (Shape shape : shapes) {
                shape.draw(g);
            }
        }
    }

}