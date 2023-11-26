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

        JScrollPane scroll = new JScrollPane(list);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(scroll);


    }
}
