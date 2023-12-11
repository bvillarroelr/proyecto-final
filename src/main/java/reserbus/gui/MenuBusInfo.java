package reserbus.gui;

import reserbus.model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Date;

/**
 * Clase que representa la información de un bus en el menú.
 */
public class MenuBusInfo extends JPanel {
    private JLabel i0, i1, i2, i3, i4;
    private JButton reservar;
    private Bus b;

    /**
     * Constructor de la clase MenuBusInfo.
     *
     * @param fe Fecha de viaje.
     * @param ci Ciudad de inicio.
     * @param cd Ciudad de destino.
     * @param hi Hora de inicio.
     * @param hd Hora de destino.
     * @param v  Referenica del objeto de la clase Ventana.
     * @param b  Referencia del objeto de la clase Bus.
     */
    MenuBusInfo(Date fe, String ci, String cd, Time hi, Time hd, Ventana v, Bus b) {
        this.b = b;
        setLayout(new GridLayout(6, 1, 50, 80));
        this.i0 = new JLabel("   FECHA DE VIAJE: " + fe);
        infoFormat(i0);
        add(i0);
        this.i1 = new JLabel("   CIUDAD DE INICIO: " + ci);
        infoFormat(i1);
        add(i1);
        this.i2 = new JLabel("   CIUDAD DE DESTINO: " + cd);
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

    /**
     * Para evitar repeticion, asigna un formato para los Labels.
     *
     * @param i Objeto JLabel que representa la información.
     */
    private void infoFormat(JLabel i) {
        i.setFont(new Font("Arial", Font.BOLD, 13));
    }
}
