package reserbus.gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BusUserData extends JPanel {
    JFrame f;
    JButton reservar = new JButton("Reservar");
    JButton volver = new JButton("Volver");

    public BusUserData(FrameAsientosBus f) {
        this.f = f;
        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                Ventana v = new Ventana();
            }
        });
        this.setLayout(new BorderLayout());
        this.add(reservar, BorderLayout.SOUTH);
        this.add(volver, BorderLayout.NORTH);
    }
}
