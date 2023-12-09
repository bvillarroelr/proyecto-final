package reserbus.gui;

import reserbus.model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class BusFrame extends JFrame {
    private BusGUI m;
    private Bus bus;
    public BusFrame(Bus bus) {
        m = new BusGUI(this,bus);
        this.bus = bus;
        setLayout(new BorderLayout());
        add(m,BorderLayout.CENTER);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Sistema reserbus");
        setSize(1080, 720);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
