package reserbus.gui;

import reserbus.model.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BusData extends JPanel {
    public JPanel info = new JPanel();
    public JPanel asientos = new JPanel();
    public JPanel total = new JPanel();
    private JLabel totalLabel;
    private Bus bus;

    /**
     * Constructor de la clase BusData.
     *
     * @param bus Objeto de la clase Bus para el cual se mostrará la información.
     */
    public BusData(Bus bus) {
        this.bus = bus;
        setLayout(new BorderLayout());
        info.setLayout(new GridLayout(4, 1));
        infoSetup(Color.RED, ": Ocupado");
        infoSetup(Color.GRAY, ": Disponible");
        infoSetup(Color.YELLOW, ": Seleccionado");
        add(info, BorderLayout.NORTH);
        add(asientos, BorderLayout.CENTER);
        totalLabel = new JLabel("Precio Total: " + 0);
        total.add(totalLabel);
        add(total, BorderLayout.SOUTH);
    }

    /**
     *Crea informacion para indicar estados de asientos.
     *
     * @param color Color que representa el estado.
     * @param s     Descripción del estado.
     */
    public void infoSetup(Color color, String s) {
        JPanel panel = new JPanel();
        JPanel paint = new JPanel();
        JLabel string = new JLabel(s);
        paint.setBackground(color);
        paint.setPreferredSize(new Dimension(10, 10));
        panel.setLayout(new BorderLayout());
        panel.add(paint, BorderLayout.WEST);
        panel.add(string, BorderLayout.CENTER);
        info.add(panel);
    }

    /**
     * Actualiza la visualización de los asientos y el precio total.
     *
     * @param asientosList Lista de asientos que se mostrarán que han sido seleccionados.
     */
    public void updateAsientos(ArrayList<Asiento> asientosList) {
        asientos.removeAll();
        float total = 0;
        asientos.setLayout(new GridLayout(20, 0));
        for (Asiento asiento : asientosList) {
            JLabel label = new JLabel("Asiento " + asiento.getID() + "    Tipo: " + asiento.getTipo() +
                    "      Precio: " + asiento.getPrecio());
            total += asiento.getPrecio();
            asientos.add(label);
        }
        totalLabel.setText("Precio Total: " + total);
        revalidate();
        repaint();
    }
}
