package Model;

import java.awt.*;
import java.awt.geom.Point2D;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Shape implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    public ArrayList<Point> points = new ArrayList<>(); //存储顶点
    public Color color;
    public float thick;
    Shape(Point a, Point b) {
        points.add(a);
        points.add(b);
        color = Color.BLACK;
        thick = 2.0f;
    }

    public abstract void draw(Graphics g);
    public abstract boolean isSelected(Point p);
    static double pointDis(Point a, Point b) {
        return (a.x - b.x)*(a.x - b.x) + (a.y - b.y)*(a.y - b.y);
    }
    static double pointToLine(Point A, Point B, Point P) {
        double r = ((P.x - A.x)*(B.x - A.x) + (P.y - A.y)*(B.y - A.y)) / pointDis(A,B);
        if (r <= 0) return Math.sqrt(pointDis(A, P));
        else if (r >= 1) return Math.sqrt(pointDis(B, P));
        else {
            double AC = r * Math.sqrt(pointDis(A, B));
            return Math.sqrt(pointDis(A, P)-AC * AC);
        }
    }
}