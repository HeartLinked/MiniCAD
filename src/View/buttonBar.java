package View;

import Controller.myController.*;
import Controller.myController;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    public static Map<JToggleButton, String> map = new HashMap<>();

    buttonBar() {
        setLayout(new GridLayout(5,1,4,4));

        add(selectButton);
        add(lineButton);
        add(rectangleButton);
        add(circleButton);
        add(textButton);
        add(boldButton);
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
    }

}
