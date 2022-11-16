package View;

import Controller.controller.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class buttonBar extends Panel {
    ImageIcon lineIcon = new ImageIcon("resource/line.png");
    public JToggleButton lineButton = new JToggleButton(lineIcon);
    ImageIcon rectangleIcon = new ImageIcon("resource/rectangle.png");
    public JToggleButton rectangleButton = new JToggleButton(rectangleIcon);
    ImageIcon circleIcon = new ImageIcon("resource/circle.png");
    public JToggleButton circleButton = new JToggleButton(circleIcon);
    ImageIcon textIcon = new ImageIcon("resource/text.png");
    public JToggleButton textButton = new JToggleButton(textIcon);
    ImageIcon boldIcon = new ImageIcon("resource/bold.png");
    public JToggleButton boldButton = new JToggleButton(boldIcon);
    ImageIcon colorIcon = new ImageIcon("resource/color.png");
    public JToggleButton colorButton = new JToggleButton(colorIcon);
    ImageIcon bigIcon = new ImageIcon("resource/big.png");
    public JToggleButton bigButton = new JToggleButton(bigIcon);
    ImageIcon smallIcon = new ImageIcon("resource/small.png");
    public JToggleButton smallButton = new JToggleButton(smallIcon);
    ImageIcon selectIcon = new ImageIcon("resource/select.png");
    public JToggleButton selectButton = new JToggleButton(selectIcon);
    ImageIcon cleanIcon = new ImageIcon("resource/clean.png");
    public JToggleButton cleanButton = new JToggleButton(cleanIcon);
    ImageIcon deleteIcon = new ImageIcon("resource/delete.png");
    public JToggleButton deleteButton = new JToggleButton(deleteIcon);
    ImageIcon thinIcon = new ImageIcon("resource/thin.png");
    public JToggleButton thinButton = new JToggleButton(thinIcon);

    public static Map<JToggleButton, String> map = new HashMap<>();

    buttonBar() {
        setLayout(new GridLayout(6,2,3,3));

        add(selectButton);
        add(lineButton);
        add(rectangleButton);
        add(circleButton);
        add(textButton);
        add(deleteButton);
        add(boldButton);
        add(thinButton);
        add(bigButton);
        add(smallButton);
        add(colorButton);
        add(cleanButton);

        map.put(lineButton, "line");
        map.put(rectangleButton, "rectangle");
        map.put(circleButton, "circle");
        map.put(textButton, "text");
        map.put(selectButton, "select");
        map.put(boldButton, "bold");
        map.put(bigButton, "big");
        map.put(smallButton, "small");
        map.put(colorButton, "color");
        map.put(cleanButton, "clean");
        map.put(deleteButton, "delete");
        map.put(thinButton, "thin");


        lineButton.addActionListener(new buttonStatusAutoChange());
        rectangleButton.addActionListener(new buttonStatusAutoChange());
        circleButton.addActionListener(new buttonStatusAutoChange());
        textButton.addActionListener(new buttonStatusAutoChange());
        selectButton.addActionListener(new buttonStatusAutoChange());
        boldButton.addActionListener(new buttonStatusAutoChange());
        bigButton.addActionListener(new buttonStatusAutoChange());
        smallButton.addActionListener(new buttonStatusAutoChange());
        colorButton.addActionListener(new buttonStatusAutoChange());
        cleanButton.addActionListener(new buttonStatusAutoChange());
        deleteButton.addActionListener(new buttonStatusAutoChange());
        thinButton.addActionListener(new buttonStatusAutoChange());

    }

}
