package Model;

import java.awt.*;
import java.io.Serial;
import java.io.Serializable;

public class Line extends Shape implements Serializable {//线段

    @Serial
    private static final long serialVersionUID = 1L;

    public Line(Point a, Point b, Color c) {
        super(a, b);
        color = c;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(thick));
        g2.setColor(color);
        g2.drawLine(points.get(0).x, points.get(0).y, points.get(1).x, points.get(1).y);
    }

    @Override
    public boolean isSelected(Point p) {
        return pointToLine(points.get(0), points.get(1), p) < 12.0;
    }

}
