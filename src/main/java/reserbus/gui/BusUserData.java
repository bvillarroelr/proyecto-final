package reserbus.gui;

import reserbus.model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Clase para ordenar las entradas y botones relacionadas con entrada del usuario.
 */
public class BusUserData extends JPanel {
    JFrame f;
    JButton volver = new JButton("Volver");
    BusUserInput ui;
    private BusDisplay dp;

    /**
     * Constructor de la clase BusUserData.
     *
     * @param f       Referencia a BusFrame asociado al panel, se pasa a UI.
     * @param bus     Referencia al objeto Bus para el cual se realizarán las operaciones de reserva.
     * @param display Referencia al objeto BusDisplay para mostrar la interfaz gráfica de los asientos.
     * @param data    Referncia al objeto BusData para manejar la información sobre los asientos y el precio total.
     */
    public BusUserData(BusFrame f, Bus bus, BusDisplay display, BusData data) {
        this.f = f;
        this.dp = display;
        this.ui = new BusUserInput(bus, dp, f, data);
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
