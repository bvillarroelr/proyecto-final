package reserbus.gui;

import javax.swing.*;
import java.awt.*;
// Lista de buses disponibles
public class MenuProgram extends JPanel {
    private int n = 5;

    public MenuProgram() {
        setLayout(new GridLayout(n, 0));
        list();
    }
    public void list() {
        removeAll();
        for (int i = 1; i <= n; i++) {
            BusButton boton = new BusButton(i);
            add(boton);
        }
        revalidate();
        repaint();
    }
}
