package Controller;

import Model.*;
import Model.Rectangle;
import Model.Shape;
import View.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Map;

public class controller {
    public static View.view view;
    public static Model.model model;
    public controller(View.view v, Model.model m) {
        view = v;
        model = m;
    }
    public static String statusNow = "";  // "selected" / "line" / "circle" / "rectangle" / "text" / "idle"
    public static String textString = "";
    public static Color selectedColor = new Color(0, 0, 0);
    public static Point dragPoint, startPoint, endPoint;
    public static Shape selectedShape ;
    public static buttonStatusAutoChange buttonStatusAutoChange = new buttonStatusAutoChange();
    public static class buttonStatusAutoChange implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JToggleButton toggleBtn = (JToggleButton) e.getSource();
            boolean status = !toggleBtn.isSelected();
            String string = buttonBar.map.get(toggleBtn);
            if(!status) {
                for (Map.Entry<JToggleButton, String> entry : View.buttonBar.map.entrySet()) {
                    String mapKey = entry.getValue();
                    if(!string.equals(mapKey)) {
                        entry.getKey().setSelected(false);
                    }
                }
                statusNow = string;
//                System.out.println(statusNow);
            } else {
//                statusNow = "idle";
                toggleBtn.setSelected(true);
//                System.out.println(statusNow);
            }
            if(statusNow.equals("line") || statusNow.equals("rectangle") || statusNow.equals("circle")) selectedShape = null;
            View.view.drawArea.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            switch (statusNow) {
                case "color" -> {
                    selectedColor = JColorChooser.showDialog(view, "颜色选择器", Color.WHITE);
                    if (selectedShape != null) {
                        selectedShape.color = selectedColor;
                        View.view.drawArea.repaint();
                    }
                }
                case "text" -> {
                    textString = JOptionPane.showInputDialog("请输入文本: ");
                    statusNow = "text";
                }
                case "clean" -> {
                    Model.model.shapes.clear();
                    View.view.drawArea.repaint();
                }
                case "bold" -> {
                    if (selectedShape != null) {
                        selectedShape.thick += 2.0f;
                        View.view.drawArea.repaint();
                    }
                }
                case "big" -> {
                    if (selectedShape != null) {
                        Point A = selectedShape.points.get(0);
                        Point B = selectedShape.points.get(1);
                        selectedShape.points.set(1, new Point((int)(1.05 * B.x - 0.05 * A.x), (int)(1.05 * B.y - 0.05 * A.y)));
                        View.view.drawArea.repaint();
                    }
                }
                case "small" -> {
                    if (selectedShape != null) {
                        Point A = selectedShape.points.get(0);
                        Point B = selectedShape.points.get(1);
                        selectedShape.points.set(1, new Point((int)(0.05 * A.x + 0.95 * B.x), (int)(0.05 * A.y + 0.95 * B.y)));
                        View.view.drawArea.repaint();
                    }
                }
                case "thin" -> {
                    if (selectedShape != null) {
                        if(selectedShape.thick > 2.0f) selectedShape.thick -= 1.5f;
                        View.view.drawArea.repaint();
                    }
                }
                case "delete" -> {
                    if (selectedShape != null) {
                        Model.model.shapes.remove(selectedShape);
                       // for(Shape shape : Model.model.shapes) {
                          //  if(shape.equals(selectedShape)) Model.model.shapes.remove(shape);
                       // }
                        View.view.drawArea.repaint();
                    }
                }
            }

        }
    }
    public static class mouseListener implements MouseListener, MouseMotionListener {

        Shape newShape;
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            if(statusNow.equals("idle")) return;
            if(statusNow.equals("select")) {
                selectedShape = null;
                View.view.drawArea.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                for (Shape a: Model.model.shapes) {
                    if(a.isSelected(e.getPoint())) {
                        selectedShape = a;
                        startPoint = a.points.get(0);
                        endPoint = a.points.get(1);
                        dragPoint = e.getPoint();
                        View.view.drawArea.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        break;
                    }
                }
                return ;
            }
            Point p = e.getPoint();
            switch (statusNow) {
                case "line":
                    newShape = new Line(p, p, selectedColor);
                    Model.model.shapes.add(newShape);
                    View.view.drawArea.repaint();
                    break;
                case "rectangle":
                    newShape = new Rectangle(p, p, selectedColor);
                    Model.model.shapes.add(newShape);
                    View.view.drawArea.repaint();
                    break;
                case "circle":
                    newShape = new Circle(p, p, selectedColor);
                    Model.model.shapes.add(newShape);
                    View.view.drawArea.repaint();
                    break;
                case "text":
                    newShape = new Text(p, p, selectedColor, textString);
                    Model.model.shapes.add(newShape);
                    View.view.drawArea.repaint();
                    break;
            }
            View.view.drawArea.repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if(statusNow.equals("rectangle") || statusNow.equals("circle") || statusNow.equals("line") || statusNow.equals("text")){
                Model.model.shapes.get(Model.model.shapes.size() - 1).points.set(1, e.getPoint());
                View.view.drawArea.repaint();
            } else if (statusNow.equals("select") && selectedShape != null) {
                Point dragToPoint = e.getPoint();
                int dx = dragToPoint.x - dragPoint.x, dy = dragToPoint.y - dragPoint.y;
                selectedShape.points.set(0, new Point(startPoint.x + dx, startPoint.y + dy));
                selectedShape.points.set(1, new Point(endPoint.x + dx, endPoint.y + dy));
                View.view.drawArea.repaint();
            }
        }
        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }
    public static class saveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Model.model.saveFile();
        }
    }
    public static class loadListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Model.model.loadFile();
        }
    }
    public static class messageListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null,"* @author: Li Feiyang" + System.getProperty("line.separator") +
                    "* @created: 2025-01-21" + System.getProperty("line.separator") +
                    "* @purpose: MiniCAD Project of Object-Oriented Technology of ssPKU" + System.getProperty("line.separator") +
                    "*  Copyright 2025 All rights reserved.");
        }
    }
}
