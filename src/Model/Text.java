package Model;

import java.awt.*;
import java.io.Serializable;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Text extends Shape implements Serializable {
    private static final long serialVersionUID = 1L;
    private String string;
    public Text(Point pp1, Point pp2, Color c, String s) {
        super(pp1, pp2);
        string = s;
        color = c;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        Point A = new Point(min(points.get(0).x, points.get(1).x), min(points.get(0).y, points.get(1).y));
        Point B = new Point(max(points.get(0).x, points.get(1).x), max(points.get(0).y, points.get(1).y));
        g.setFont(new Font("宋体", Font.PLAIN, (B.y-A.y)/2));
        g.drawString(string, A.x, B.y);
    }

    @Override
    public boolean isSelected(Point p) {
        Point leftUp = new Point(min(points.get(0).x, points.get(1).x), min(points.get(0).y, points.get(1).y));
        Point rightDown = new Point(max(points.get(0).x, points.get(1).x), max(points.get(0).y, points.get(1).y));
        Point rightUp = new Point(max(points.get(0).x, points.get(1).x), min(points.get(0).y, points.get(1).y));
        Point leftDown = new Point(min(points.get(0).x, points.get(1).x), max(points.get(0).y, points.get(1).y));
        if(pointToLine(leftUp, rightUp, p)< 25.0) return true;
        if(pointToLine(leftUp, leftDown, p)< 25.0) return true;
        if(pointToLine(leftDown, rightDown, p)< 25.0) return true;
        if(pointToLine(rightUp, rightDown, p)< 25.0) return true;
        return false;
    }

    public void setText(String s) {
        string = s;
    }
}