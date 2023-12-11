package reserbus.gui;

import reserbus.model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase que representa la lista de buses disponibles en el menú.
 */
public class MenuProgram extends JPanel implements ActionListener {
    private MenuInfo mi;
    private int n = 4;
    private ArrayList<JButton> listaBotones;
    private ArrayList<Bus> listaBuses;
    private Ventana v;
    private JPanel panel = new JPanel();

    /**
     * Constructor de la clase MenuProgram.
     *
     * @param v  Referencia al Objeto de la clase Ventana.
     * @param mi Referencia al Objeto de la clase MenuInfo.
     */
    public MenuProgram(Ventana v, MenuInfo mi) {
        this.mi = mi;
        this.v = v;
        panel.setLayout(new GridLayout(0, 3));
        panel.setBackground(new Color(216, 245, 185));
        info("Codigo", panel);
        info("Inicio", panel);
        info("Destino", panel);
        listaBotones = new ArrayList<JButton>();
        listaBuses = new ArrayList<>();
        construirBuses();
        for (int i = 0; i < n; i++) {
            listaBotones.add(new JButton());
        }
        drawList();
    }

    /**
     * Dibuja la lista de buses en el menú.
     */
    public void drawList() {
        int n = listaBotones.size();
        if (n <= 6) {
            setLayout(new GridLayout(7, 1));
            add(panel);
            for (int i = 0; i < n; i++) {
                JButton boton = new JButton();
                boton.setPreferredSize(new Dimension(300, 100));
                boton.setLabel("Viaje " + (i + 1));
                boton.setBackground(new Color(255, 207, 124));
                boton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                boton.addActionListener(this);
                listaBotones.set(i, boton);
                add(boton);
            }
            for (int i = n; i < 6; i++) {
                JLabel v = new JLabel();
                v.setPreferredSize(new Dimension(300, 100));
                add(v);
            }
            revalidate();
            repaint();
        } else {
            setLayout(new GridLayout(listaBotones.size() + 1, 0));
            add(panel);
            for (int i = 0; i < n; i++) {
                JButton boton = new JButton();
                boton.setPreferredSize(new Dimension(300, 100));
                boton.setLabel("                          Viaje                                " + i);
                boton.addActionListener(this);
                listaBotones.set(i, boton);
                add(boton);
            }
            revalidate();
            repaint();
        }
    }

    /**
     * Agrega información al panel.
     *
     * @param t Texto a agregar.
     * @param p Panel al que se agrega la información.
     */
    public void info(String t, JPanel p) {
        JLabel l = new JLabel(t);
        l.setPreferredSize(new Dimension(100, 100));
        l.setHorizontalAlignment(JLabel.CENTER);
        l.setVerticalAlignment(JLabel.CENTER);
        l.setFont(new Font("Arial", Font.BOLD, 18));
        p.add(l);
    }

    /**
     * Construye los buses utilizando el patrón Builder.
     */
    public void construirBuses() {
        Director d = new Director();
        BusBuilder builder = new BusBuilder() {
        };
        for (int i = 0; i < n; i++) {
            if (i < 2) {
                d.constructBusSimpleDia(builder, "Concepción", "Santiago", new Date(2024, 1, i));
                Bus b = builder.getResult();
                listaBuses.add(b);
            } else {
                d.constructBus2PisosDia(builder, "Concepción", "Villarrica", new Date(2024, 2, i));
                Bus b = builder.getResult();
                listaBuses.add(b);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int n = listaBotones.size();
        for (int i = 0; i < n; i++) {
            if (e.getSource() == listaBotones.get(i)) {
                changeInfo(listaBuses.get(i).getFecha(), listaBuses.get(i).getLugarInicio(), listaBuses.get(i).getLugarDestino(), listaBuses.get(i).getHoraInicio(), listaBuses.get(i).getHoraDestino(), listaBuses.get(i));
            }
        }
    }

    /**
     * Cambia la información en el panel de información.
     *
     * @param fe Fecha de viaje.
     * @param li Ciudad de inicio.
     * @param ld Ciudad de destino.
     * @param hi Hora de inicio.
     * @param hd Hora de destino.
     * @param b  Objeto de la clase Bus.
     */
    public void changeInfo(Date fe, String li, String ld, Time hi, Time hd, Bus b) {
        MenuBusInfo mbi = new MenuBusInfo(fe, li, ld, hi, hd, v, b);
        mi.changeBus(mbi);
    }
}
