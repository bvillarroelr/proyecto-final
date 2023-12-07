package reserbus.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBusInfo extends JPanel {
    JLabel i1,i2,i3,i4;
    JButton reservar;
    MenuBusInfo(String PH,Ventana v) {
        setLayout(new GridLayout(5,1,50,100));
        this.i1 = new JLabel("   CODIGO: " + PH);
        infoFormat(i1);
        add(i1);
        this.i2 = new JLabel("   HORA DE INICIO: "+ PH);
        infoFormat(i2);
        add(i2);
        this.i3 = new JLabel("   CIUDAD DE INICIO: " + PH);
        infoFormat(i3);
        add(i3);
        this.i4 = new JLabel("   CIUDAD DE DESTINO: " + PH);
        infoFormat(i4);
        add(i4);
        this.reservar = new JButton("Reservar");
        add(reservar);
        reservar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v.dispose();
                FrameAsientosBus ventanaNueva = new FrameAsientosBus();
            }
        });
    }
    private void infoFormat(JLabel i) {
        i.setFont(new Font("Arial", Font.BOLD, 13));
    }
}
