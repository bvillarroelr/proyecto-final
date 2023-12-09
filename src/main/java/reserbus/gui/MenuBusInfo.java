package reserbus.gui;

import reserbus.model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;

public class MenuBusInfo extends JPanel {
    private JLabel i1,i2,i3,i4;
    private JButton reservar;
    private Bus b;
    MenuBusInfo(String ci, String cd, Time hi, Time hd, Ventana v, Bus b) {
        this.b = b;
        setLayout(new GridLayout(5,1,50,100));
        this.i1 = new JLabel("   CIUDAD DE INICIO:: " + ci);
        infoFormat(i1);
        add(i1);
        this.i2 = new JLabel("   CIUDAD DE DESTINO: "+ cd);
        infoFormat(i2);
        add(i2);
        this.i3 = new JLabel("   HORA DE INICIO: " + hi);
        infoFormat(i3);
        add(i3);
        this.i4 = new JLabel("   HORA DE DESTINO: " + hd);
        infoFormat(i4);
        add(i4);
        this.reservar = new JButton("Reservar");
        add(reservar);
        reservar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v.dispose();
                BusFrame ventanaNueva = new BusFrame(b);
            }
        });
    }
    private void infoFormat(JLabel i) {
        i.setFont(new Font("Arial", Font.BOLD, 13));
    }
}
