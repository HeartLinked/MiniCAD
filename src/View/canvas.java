package View;

import Controller.controller;
import Model.Shape;

import java.awt.*;
import java.io.Serial;

import static Model.model.shapes;

public class canvas extends Canvas {

    @Serial
    private static final long serialVersionUID = 1L;

    canvas() {
        setBackground(Color.WHITE);
        addMouseListener(new controller.mouseListener());
        addMouseMotionListener(new controller.mouseListener());
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