package reserbus.gui;

import javax.swing.*;
import java.awt.*;

// Bienvenida y cualquier cosa extra
public class MenuInfo extends JPanel {
    private JLabel info;
    private MenuBusInfo mbi;
    private JPanel actual = new JPanel();

    public MenuInfo() {
        setLayout(new BorderLayout());
        info = new JLabel("Bienvenido a Reserbus");
        info.setPreferredSize(new Dimension(300, 100));
        info.setHorizontalAlignment(JLabel.CENTER);
        info.setVerticalAlignment(JLabel.CENTER);
        info.setFont(new Font("Arial", Font.BOLD, 18));
        this.add(info,BorderLayout.NORTH);
        this.add(actual,BorderLayout.CENTER);
    }
    public void changeBus(JPanel f){
        remove(actual);
        add(f);
        actual = f;
        revalidate();
        repaint();
    }
}
