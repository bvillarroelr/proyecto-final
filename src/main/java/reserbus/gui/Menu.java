package reserbus.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa el JPanel menú principal y sus componentes.
 */
public class Menu extends JPanel {
    MenuInfo menuI = new MenuInfo();
    MenuProgram menuP;

    /**
     * Constructor de la clase Menu.
     *
     * @param v Objeto de la clase Ventana para asignárselo a menuP y trabajar con los Listeners.
     */
    public Menu(Ventana v) {
        this.setLayout(new GridLayout(1, 2));
        this.setBackground(Color.white);
        this.add(menuI);
        menuP = new MenuProgram(v, menuI);
        new MenuProgram(v, menuI);
        menuI.setBackground(new Color(147, 236, 134));

        JScrollPane scroll = new JScrollPane(menuP);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(scroll);
    }
}
