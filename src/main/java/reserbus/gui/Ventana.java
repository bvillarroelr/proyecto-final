package reserbus.gui;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    public Ventana() {
        this.setLayout(new BorderLayout());

        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Sistema reserbus");
        this.setSize(800, 600);
        this.setVisible(true);;
    }
}
