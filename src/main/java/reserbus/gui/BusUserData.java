package reserbus.gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BusUserData extends JPanel {
    JFrame f;
    JButton volver = new JButton("Volver");
    BusUserInput ui = new BusUserInput();

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
        this.add(ui);
        this.add(volver, BorderLayout.NORTH);
    }
}
