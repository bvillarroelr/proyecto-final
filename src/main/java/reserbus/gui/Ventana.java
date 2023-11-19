package reserbus.gui;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    JPanel GUIManager;
    public Ventana() {
        this.GUIManager = new JPanel();
        this.setLayout(new BorderLayout());

        this.getContentPane().add(GUIManager);

        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Sistema reserbus");
        this.setSize(800, 600);
        this.setVisible(true);;
    }
}
