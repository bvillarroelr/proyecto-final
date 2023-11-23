package reserbus.gui;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    private Menu m = new Menu();
    private BusGUI g = new BusGUI();
    private Feedback f = new Feedback();
    public Ventana() {
        this.setLayout(new BorderLayout());
        this.add(g,BorderLayout.CENTER);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Sistema reserbus");
        this.setSize(800, 600);
        this.setVisible(true);;
    }
}
