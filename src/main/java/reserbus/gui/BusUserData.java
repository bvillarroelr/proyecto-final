package reserbus.gui;
import reserbus.model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BusUserData extends JPanel {
    JFrame f;
    JButton volver = new JButton("Volver");
    BusUserInput ui;
    private BusDisplay dp;

    public BusUserData(BusFrame f,Bus bus,BusDisplay display,BusData data) {
        this.f = f;
        this.dp = display;
        this.ui = new BusUserInput(bus,dp,f,data);
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
