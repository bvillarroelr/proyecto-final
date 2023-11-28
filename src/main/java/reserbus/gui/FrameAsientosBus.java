package reserbus.gui;

import javax.swing.*;

public class FrameAsientosBus extends JFrame {
    public FrameAsientosBus() {
        this.setSize(460,460);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("Bus + (tipo de bus) + (destino)");
        this.add(new JLabel("TEST"));
        this.setVisible(true);
    }
}
