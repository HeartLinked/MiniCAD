package Controller;

import View.buttonBar;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class buttonStatusAutoChange implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        // 相应的逻辑判断
        JToggleButton toggleBtn = (JToggleButton) e.getSource();
        boolean status = !toggleBtn.isSelected();
        System.out.println(status ? 1 : 0);
        String string = buttonBar.map.get(toggleBtn);
        System.out.println("aq" + string);
        for (Map.Entry<JToggleButton, String> entry : View.buttonBar.map.entrySet()) {
            String mapKey = entry.getValue();
            if(!string.equals(mapKey)) {
                System.out.println(mapKey);
                entry.getKey().setSelected(status);
            }
        }
    }
}
