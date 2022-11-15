package Model;

import java.awt.*;
import java.io.Serial;
import java.io.Serializable;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Rectangle extends Shape implements Serializable {//矩形

    private static final long serialVersionUID = 1L;

    public Rectangle(Point a, Point b, Color c) {
        super(a, b);
        color = c;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(thick));
        g2.setColor(color);
        Point A = new Point(min(points.get(0).x, points.get(1).x), min(points.get(0).y, points.get(1).y));
        Point B = new Point(max(points.get(0).x, points.get(1).x), max(points.get(0).y, points.get(1).y));
        g2.drawRect(A.x, A.y, B.x - A.x, B.y - A.y);
    }

    @Override
    public boolean isSelected(Point p) {
        Point leftUp = new Point(min(points.get(0).x, points.get(1).x), min(points.get(0).y, points.get(1).y));
        Point rightDown = new Point(max(points.get(0).x, points.get(1).x), max(points.get(0).y, points.get(1).y));
        Point rightUp = new Point(max(points.get(0).x, points.get(1).x), min(points.get(0).y, points.get(1).y));
        Point leftDown = new Point(min(points.get(0).x, points.get(1).x), max(points.get(0).y, points.get(1).y));
        if(pointToLine(leftUp, rightUp, p)< 12.0) return true;
        if(pointToLine(leftUp, leftDown, p)< 12.0) return true;
        if(pointToLine(leftDown, rightDown, p)< 12.0) return true;
        if(pointToLine(rightUp, rightDown, p)< 12.0) return true;
        return false;
    }

}
