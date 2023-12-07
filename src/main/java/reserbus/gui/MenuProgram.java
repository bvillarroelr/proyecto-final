package reserbus.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Lista de buses disponibles
public class MenuProgram extends JPanel implements ActionListener {
    private MenuInfo mi;
    private int n = 4;
    private ArrayList<JButton> listaBotones;    // De esta forma podemos acceder a los botones de manera individual.
    private Ventana v;  // Para poder hacer actionPerformed de cerrarla y abrir FrameAsientoBus cuando se clickee un botón
    private JPanel panel = new JPanel();
    public MenuProgram(Ventana v,MenuInfo mi) {
        this.mi = mi;
        this.v = v;
        panel.setLayout(new GridLayout(0,3));
        info("Codigo", panel);
        info("Inicio", panel);
        info("Destino", panel);
        // Temporalmente instancio el ArrayList desde aqui para tener un tamaño con el que trabajar, pero se podría instanciar con un for que dependa de otra variable entera por ejemplo
        listaBotones = new ArrayList<JButton>();

        for(int i = 0; i < n; i++) {    // ahora podemos acceder al boton y sus propiedades, pero nos interesa manipular su actionPerformed
            JButton boton = new JButton();
            listaBotones.add(boton);
            //listaBotones.add(new JButton());
        }
        drawList();
    }
    public void drawList() {
        int n = listaBotones.size();
        if(n<=6) {
            setLayout(new GridLayout(7, 1));
            add(panel);
            for (int i = 0; i < n; i++) {
                JButton boton = new JButton();
                boton.setPreferredSize(new Dimension(300, 100));
                boton.setLabel("Viaje "+i);
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
        }
        else{
            setLayout(new GridLayout(listaBotones.size()+1, 0));
            add(panel);
            for (int i = 0; i < n; i++) {
                JButton boton = new JButton();
                boton.setPreferredSize(new Dimension(300, 100));
                boton.setLabel("Viaje "+i);
                boton.addActionListener(this);
                listaBotones.set(i, boton);
                add(boton);
            }
            revalidate();
            repaint();
        }
    }
    public void info(String t,JPanel p){
        JLabel l = new JLabel(t);
        l.setPreferredSize(new Dimension(100, 100));
        l.setHorizontalAlignment(JLabel.CENTER);
        l.setVerticalAlignment(JLabel.CENTER);
        l.setFont(new Font("Arial", Font.BOLD, 18));
        p.add(l);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int n = listaBotones.size();
        for(int i = 0; i<n; i++) {
            if(e.getSource() == listaBotones.get(i)) {
                changeInfo();
            }
        }
    }
    public void changeInfo() {
        MenuBusInfo mbi = new MenuBusInfo("PLACE_HOLDER",v);
        mi.changeBus(mbi);
    }
}
