package View;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;
import java.util.Random;

public class myView extends JFrame {

    private String shape="";
    public static MyCanvas drawArea = new MyCanvas();
    public myView() {
        super("MiniCAD");
        setSize(1000, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myMenuBar menuBar = new myMenuBar();
        setJMenuBar(menuBar.menuBar);

        Panel myButtonBar = new buttonBar();
        add(myButtonBar, BorderLayout.EAST);

        drawArea.setPreferredSize(null); // new dimension(300, 200)
        add(drawArea);

        init();
    }


    private void init() {
//        pack();
        setVisible(true);
        setResizable(false);
        setBackground(Color.WHITE);
        setLocationRelativeTo(null);
    }

}
