package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class myMenuBar {

    JMenuBar menuBar = new JMenuBar();

    JMenu menuFile = new JMenu("File");
    JMenu menuHelp = new JMenu("Help");

    JMenuItem open = new JMenuItem("Open");
    JMenuItem save = new JMenuItem("Save");
    JMenuItem exit = new JMenuItem("Exit");

    JMenuItem quickStart = new JMenuItem("Quick Start");
    JMenuItem aboutMiniCAD = new JMenuItem("About MiniCAD");

    myMenuBar() {
        addElements();
        addListener();
    }

    void addElements() {
        menuBar.add(menuFile);
        menuBar.add(menuHelp);

        menuHelp.add(quickStart);
        menuHelp.add(aboutMiniCAD);

        menuFile.add(open);
        menuFile.add(save);
        menuFile.add(exit);
    }

    void addListener() {
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("CLICKED");
            }
        });
    }
}
