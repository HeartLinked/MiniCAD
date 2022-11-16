package Model;

import Controller.cadFileFilter;
import View.myView;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.ArrayList;

public class myModel {

    public static ArrayList<Shape> shapes = new ArrayList<Shape>(); //存放所有图形
    public static void saveFile() {
        JFileChooser chooser=new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Cad画板文件(*.cad)", "cad");
        chooser.setFileFilter(filter);
        chooser.showSaveDialog(null);
        chooser.setDialogTitle("保存文件");
        File file = chooser.getSelectedFile();
        if(file != null) {
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
                out.writeObject(shapes);
                JOptionPane.showMessageDialog(null,"保存成功!");
                out.close();
            }
            catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,"保存失败!");
            }
        }

    }
    public static void loadFile() {
        int confirmDialog = JOptionPane.showConfirmDialog(null, "是否保存文件", "提示信息", 0);
        if(confirmDialog == 0) {
            saveFile();
        }
        try {
            JFileChooser chooser = new JFileChooser();
            cadFileFilter filter = new cadFileFilter();
            chooser.setFileFilter(filter);
            chooser.addChoosableFileFilter(filter);
            chooser.setDialogTitle("请选择保存的cad文件打开：");
            chooser.showOpenDialog(null);
            File file = chooser.getSelectedFile();
            if(file==null){
                JOptionPane.showMessageDialog(null, "未选择文件!");
            }
            else {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
                shapes = ((ArrayList<Shape>)in.readObject());
                myView.drawArea.repaint();
                in.close();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"打开失败!");
        }
    }
}

