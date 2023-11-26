package reserbus.gui;

import javax.swing.*;
import java.awt.*;
// Lista de buses disponibles
public class MenuProgram extends JPanel {
    private int n = 10;
    private JPanel i = new JPanel();
    public MenuProgram() {
        i.setLayout(new GridLayout(0,3));
        info("Codigo",i);
        info("Inicio",i);
        info("Destino",i);
        if(n<=6){
            smallList();
        }
        else{
            setLayout(new GridLayout(n+1, 0));
            add(i);
            list();
        }
    }
    public void list() {
        for (int i = 1; i <= n; i++) {
            JButton boton = new JButton();
            boton.setPreferredSize(new Dimension(300, 100));
            add(boton);
        }
        revalidate();
        repaint();
    }
    public void info(String t,JPanel p){
        JLabel l = new JLabel(t);
        l.setPreferredSize(new Dimension(100, 100));
        l.setHorizontalAlignment(JLabel.CENTER);
        l.setVerticalAlignment(JLabel.CENTER);
        l.setFont(new Font("Arial", Font.BOLD, 18));
        p.add(l);
    }
    private void smallList(){
        setLayout(new GridLayout(7, 1));
        add(i);
        for (int i = 1; i <= n; i++) {
            JButton boton = new JButton();
            boton.setPreferredSize(new Dimension(300, 100));
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
}
