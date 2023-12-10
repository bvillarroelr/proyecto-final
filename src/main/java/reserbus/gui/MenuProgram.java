package reserbus.gui;

import reserbus.model.Bus;
import reserbus.model.BusBuilder;
import reserbus.model.Director;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

// Lista de buses disponibles
public class MenuProgram extends JPanel implements ActionListener {
    private MenuInfo mi;
    private int n = 4;                          // Numero de botones y viajes generados 
    private ArrayList<JButton> listaBotones;    // De esta forma podemos acceder a los botones de manera individual.
    private ArrayList<Bus> listaBuses;          // El objetivo es lograr hacer coincidir cada botón de la lista, con un único bus asociado.
    private Ventana v;  // Para poder hacer actionPerformed de cerrarla y abrir FrameAsientoBus cuando se clickee un botón
    private JPanel panel = new JPanel();

    public MenuProgram(Ventana v, MenuInfo mi) {
        this.mi = mi;
        this.v = v;
        panel.setLayout(new GridLayout(0, 3));
        panel.setBackground(new Color(216, 245, 185));
        info("Codigo", panel);
        info("Inicio", panel);
        info("Destino", panel);
        listaBotones = new ArrayList<JButton>();
        // creamos buses (builder)
        listaBuses = new ArrayList<>();
        construirBuses();
        for (int i = 0; i < n; i++) {    // ahora podemos acceder al boton y sus propiedades, pero nos interesa manipular su actionPerformed
            listaBotones.add(new JButton());
        }
        drawList();
    }

    public void drawList() {
        int n = listaBotones.size();
        if (n <= 6) {
            setLayout(new GridLayout(7, 1));
            add(panel);
            for (int i = 0; i < n; i++) {
                JButton boton = new JButton();
                boton.setPreferredSize(new Dimension(300, 100));
                boton.setLabel("Viaje " + (i+1));
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
                boton.setLabel("Viaje " + i);
                boton.addActionListener(this);
                listaBotones.set(i, boton);
                add(boton);
            }
            revalidate();
            repaint();
        }
    }

    public void info(String t, JPanel p) {
        JLabel l = new JLabel(t);
        l.setPreferredSize(new Dimension(100, 100));
        l.setHorizontalAlignment(JLabel.CENTER);
        l.setVerticalAlignment(JLabel.CENTER);
        l.setFont(new Font("Arial", Font.BOLD, 18));
        p.add(l);
    }

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
                d.constructBus2PisosDia(builder, "Concepción", "Villarica", new Date(2024, 2, i));
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
                changeInfo(listaBuses.get(i).getLugarInicio(), listaBuses.get(i).getLugarDestino(), listaBuses.get(i).getHoraInicio(), listaBuses.get(i).getHoraDestino(), listaBuses.get(i));
            }
        }
    }

    public void changeInfo(String li, String ld, Time hi, Time hd, Bus b) {
        MenuBusInfo mbi = new MenuBusInfo(li, ld, hi ,hd ,v,b);
        mi.changeBus(mbi);
    }
}
