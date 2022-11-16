package View;

import Controller.controller;

import javax.swing.*;

class menuBar {

    JMenuBar menuBar = new JMenuBar();

    JMenu menuFile = new JMenu("File        ");
    JMenu menuHelp = new JMenu("Help");

    JMenuItem open = new JMenuItem("Open");
    JMenuItem save = new JMenuItem("Save");
    JMenuItem aboutMiniCAD = new JMenuItem("About MiniCAD");

    menuBar() {
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
        open.addActionListener(new controller.loadListener());
        save.addActionListener(new controller.saveListener());
        aboutMiniCAD.addActionListener(new controller.messageListener());
    }
}
