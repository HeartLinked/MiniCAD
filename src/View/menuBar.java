package View;

import Controller.myController;
import Model.myModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class myMenuBar {

    JMenuBar menuBar = new JMenuBar();

    JMenu menuFile = new JMenu("File        ");
    JMenu menuHelp = new JMenu("Help");

    JMenuItem open = new JMenuItem("Open");
    JMenuItem save = new JMenuItem("Save");
    JMenuItem aboutMiniCAD = new JMenuItem("About MiniCAD");

    myMenuBar() {
        addElements();
        addListener();
    }

    void addElements() {
        menuBar.add(menuFile);
        menuBar.add(menuHelp);

        menuHelp.add(aboutMiniCAD);

        menuFile.add(open);
        menuFile.add(save);
    }

    void addListener() {
        open.addActionListener(new myController.loadListener());
        save.addActionListener(new myController.saveListener());
        aboutMiniCAD.addActionListener(new myController.messageListener());
    }
}
