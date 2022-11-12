package View;

import javax.swing.*;
import java.awt.*;

public class myView extends JFrame {

    public myView() {
        super("MiniCAD");
        setSize(1000, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myMenuBar myMenuBar1 = new myMenuBar();
        setJMenuBar(myMenuBar1.menuBar);

        Panel panel = new Panel();
        panel.setLayout(new GridLayout(5,1,4,4));


        ImageIcon lineIcon = new ImageIcon("resource/line.png");
        JToggleButton lineButton = new JToggleButton(lineIcon);
        ImageIcon rectangleIcon = new ImageIcon("resource/rectangle.png");
        JToggleButton rectangleButton = new JToggleButton(rectangleIcon);
        ImageIcon circleIcon = new ImageIcon("resource/circle.png");
        JToggleButton circleButton = new JToggleButton(circleIcon);
        ImageIcon textIcon = new ImageIcon("resource/text.png");
        JToggleButton textButton = new JToggleButton(textIcon);
        ImageIcon boldIcon = new ImageIcon("resource/bold.png");
        JToggleButton boldButton = new JToggleButton(boldIcon);
        ImageIcon colorIcon = new ImageIcon("resource/color.png");
        JToggleButton colorButton = new JToggleButton(colorIcon);
        ImageIcon bigIcon = new ImageIcon("resource/big.png");
        JToggleButton bigButton = new JToggleButton(bigIcon);
        ImageIcon smallIcon = new ImageIcon("resource/small.png");
        JToggleButton smallButton = new JToggleButton(smallIcon);
        ImageIcon selectIcon = new ImageIcon("resource/select.png");
        JToggleButton selectButton = new JToggleButton(selectIcon);
        ImageIcon cleanIcon = new ImageIcon("resource/clean.png");
        JToggleButton cleanButton = new JToggleButton(cleanIcon);
//        ImageIcon saveIcon = new ImageIcon("resource/save.png");
//        JToggleButton saveButton = new JToggleButton(saveIcon);
//        ImageIcon loadIcon = new ImageIcon("resource/load.png");
//        JToggleButton loadButton = new JToggleButton(loadIcon);


        panel.add(lineButton);
        panel.add(rectangleButton);
        panel.add(circleButton);
        panel.add(textButton);
        panel.add(selectButton);
        panel.add(boldButton);
        panel.add(bigButton);
        panel.add(smallButton);
        panel.add(colorButton);
        panel.add(cleanButton);

//        panel.add(saveButton);
//        panel.add(loadButton);

        add(panel, BorderLayout.EAST);

        init();
    }


    private void init() {
//        pack();
        setVisible(true);
        setBackground(Color.WHITE);
        setLocationRelativeTo(null);
    }


}

//        JButton jButton = new JButton("OK");
//        add(jButton, BorderLayout.NORTH);