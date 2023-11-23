package reserbus.gui;

import javax.swing.*;
import java.awt.*;
// Menu Principal
public class Menu extends JPanel {
    MenuInfo info = new MenuInfo();
    MenuProgram list = new MenuProgram();
    public Menu() {
        this.setLayout(new GridLayout(1,2));
        this.setBackground(Color.white);
        this.add(info);
        this.add(list);
    }
}
