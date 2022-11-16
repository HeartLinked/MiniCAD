package View;

import javax.swing.*;
import java.awt.*;

public class view extends JFrame {

    private String shape="";
    public static canvas drawArea = new canvas();
    public view() {
        super("MiniCAD");
        setSize(1000, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        View.menuBar menuBar = new menuBar();
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
