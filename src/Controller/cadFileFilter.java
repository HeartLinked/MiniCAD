package Controller;

import java.io.File;

public class cadFileFilter extends javax.swing.filechooser.FileFilter {
    public boolean accept(File f) {
        if (f.isDirectory()) return true;
        return f.getName().endsWith(".cad");  //选择以.cad为后缀的文件
    }
    public String getDescription() {
        return "Cad画板文件(*.cad)";
    }
}