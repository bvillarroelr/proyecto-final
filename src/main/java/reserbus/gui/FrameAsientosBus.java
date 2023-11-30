package reserbus.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameAsientosBus extends JFrame implements ActionListener {
    private BusGUI m;
    private JButton volverAlMenu;
    public FrameAsientosBus() {
        m = new BusGUI(this);
        setLayout(new BorderLayout());
        add(m,BorderLayout.CENTER);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Sistema reserbus");
        setSize(1080, 720);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == volverAlMenu) {
            // falta hacer logica para volver a la ventana anterior
        }
    }
}
