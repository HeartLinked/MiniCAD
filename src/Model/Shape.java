package Model;

import java.awt.*;
import java.awt.geom.Point2D;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Shape implements Serializable{

    @Serial
    private static final long serialVersionUID = 1L;
    public ArrayList<Point> points = new ArrayList<>(); //存储多边形和多点折线的顶点
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

    public void changeSize(String s) {
        Point centerP = getCenterP();
        for(int i = 0; i < points.size(); i++) {
            changeSizePoint(s, i, centerP);
        }
    }

    public void changeSizePoint(String s, int i, Point centerP) {
        int flag = 1;
        Point p1 = points.get(i);
        Point p2 = centerP;
        if(s.equals("small")) {
            flag = -1;
        }
        if((p1.x < p2.x && p1.y < p2.y)) {
            double dx = flag * (p2.x - p1.x) * 0.1;
            double dy = flag * (p2.y - p1.y) * 0.1;
            p1.x -= dx;
            p1.y -= dy;
        }
        if((p1.x > p2.x && p1.y > p2.y)) {
            double dx = flag * (p1.x - p2.x) * 0.1;
            double dy = flag * (p1.y - p2.y) * 0.1;
            p1.x += dx;
            p1.y += dy;
        }
        if((p1.x < p2.x && p1.y > p2.y)) {
            double dx = flag * (p2.x - p1.x) * 0.1;
            double dy = flag * (p1.y - p2.y) * 0.1;
            p1.x -= dx;
            p1.y += dy;
        }
        if((p1.x > p2.x && p1.y < p2.y)) {
            double dx = flag * (p1.x - p2.x) * 0.1;
            double dy = flag * (p2.y - p1.y) * 0.1;
            p1.x += dx;
            p1.y -= dy;
        }
    }

    public Point getCenterP() {
        int sumX = 0;
        int sumY = 0;
        for(int i = 0; i < points.size(); i++) {
            sumX += points.get(i).x;
            sumY += points.get(i).y;
        }
        return new Point(sumX/ points.size(), sumY/ points.size());
    }

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



//class Oval extends Shape implements Serializable {
//
//    /**
//     *
//     */
//    private static final long serialVersionUID = 1L;
//
//    Oval(Point pp1, Point pp2) {
//        super(pp1, pp2);
//    }
//
//    @Override
//    public void draw(Graphics g) {
//        Graphics2D g2 = (Graphics2D)g;
//        g2.setStroke(new BasicStroke(thick));
//        g2.setColor(color);
//        Point points[] = adjustPoint();
//        g2.drawOval(points[0].x, points[0].y, points[1].x - points[0].x, points[1].y - points[0].y);
//    }
//
//    @Override
//    protected boolean isSelected(Point p) {
//        Point[] points = adjustPoint();
//        if(p.x > points[0].x && p.y > points[0].y && p.x<points[1].x && p.y<points[1].y)
//            return true;
//        else return false;
//    }
//
//}
//
//class Text extends Shape implements Serializable {
//    /**
//     *
//     */
//    private static final long serialVersionUID = 1L;
//    private String t;
//    Text(Point pp1, Point pp2, String tt) {
//        super(pp1, pp2);
//        t = tt;
//    }
//
//    @Override
//    public void draw(Graphics g) {
//        g.setColor(color);
//        Point points[] = adjustPoint();
//        g.setFont(new Font("宋体", Font.PLAIN, (points[1].y-points[0].y)/2));
//        g.drawString(t, points[0].x, points[1].y);
//    }
//
//    @Override
//    protected boolean isSelected(Point p) {
//        Point[] points = adjustPoint();
//        if(p.x > points[0].x && p.y > points[0].y && p.x<points[1].x && p.y<points[1].y)
//            return true;
//        else return false;
//    }
//
//    public void setText(String tt) {
//        t = tt;
//    }
//}