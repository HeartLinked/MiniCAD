package Controller;

import Model.*;
import Model.Rectangle;
import Model.Shape;
import View.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Map;

public class myController {
    public static myView view;
    public static myModel model;
    public myController(myView v, myModel m) {
        view = v;
        model = m;
    }
    public static String statusNow = "";  // "selected" / "line" / "circle" / "rectangle" / "text" / "idle"
    public static String textString = "";
    public static Color selectedColor = new Color(0, 0, 0);
    public static Shape selectedShape ;

    public static buttonStatusAutoChange buttonStatusAutoChange = new buttonStatusAutoChange();

    public static class buttonStatusAutoChange implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // 相应的逻辑判断
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
            myView.drawArea.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            switch (statusNow) {
                case "color" -> {
                    selectedColor = JColorChooser.showDialog(view, "颜色选择器", Color.WHITE);
                    if (selectedShape != null) {
                        selectedShape.color = selectedColor;
                        myView.drawArea.repaint();
                    }
                }
                case "text" -> {
                    textString = JOptionPane.showInputDialog("请输入文本: ");
                    statusNow = "text";
                }
                case "clean" -> {
                    myModel.shapes.clear();
                    myView.drawArea.repaint();
                }
                case "bold" -> {
                    if (selectedShape != null) {
                        selectedShape.thick += 2.0f;
                        myView.drawArea.repaint();
                    }
                }
            }

        }
    }

    public static class mouseListener implements MouseListener, MouseMotionListener {

        Point startPoint, endPoint;
        Shape newShape;
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            if(statusNow.equals("idle")) return;
            if(statusNow.equals("select")) {
                for (Shape a: myModel.shapes) {
                    if(a.isSelected(e.getPoint())) {
                        selectedShape = a;
                        myView.drawArea.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        break;
                    }
                }
                return ;
            }
            startPoint = e.getPoint();
            endPoint = startPoint;
            switch (statusNow) {
                case "line":
                    newShape = new Line(startPoint, endPoint, selectedColor);
                    myModel.shapes.add(newShape);
                    myView.drawArea.repaint();
                    break;
                case "rectangle":
                    newShape = new Rectangle(startPoint, endPoint, selectedColor);
                    myModel.shapes.add(newShape);
                    myView.drawArea.repaint();
                    break;
                case "circle":
                    newShape = new Circle(startPoint, endPoint, selectedColor);
                    myModel.shapes.add(newShape);
                    myView.drawArea.repaint();
                    break;
                case "text":
                    newShape = new Text(startPoint, endPoint, selectedColor, textString);
                    myModel.shapes.add(newShape);
                    myView.drawArea.repaint();
                    break;
            }
            myView.drawArea.repaint();
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
                myModel.shapes.get(myModel.shapes.size() - 1).points.set(1, e.getPoint());
                myView.drawArea.repaint();
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }

}
