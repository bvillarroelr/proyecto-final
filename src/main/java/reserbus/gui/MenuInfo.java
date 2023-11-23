package reserbus.gui;

import javax.swing.*;
// Bienvenida y cualquier cosa extra
public class MenuInfo extends JPanel {
    private JLabel info;

    public MenuInfo() {
        info = new JLabel("Bienvenido a Reserbus");
        this.add(info);
    }
}
