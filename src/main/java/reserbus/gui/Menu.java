package reserbus.gui;

import javax.swing.*;
import java.awt.*;
// Menu Principal
public class Menu extends JPanel {
    MenuInfo menuI = new MenuInfo();
    MenuProgram menuP;
    public Menu(Ventana v) {    // Recibe parámetro Ventana para asignarselo a menuP (para poder trabajar con los Listeners y abrir otras ventanas)
        this.setLayout(new GridLayout(1,2));
        this.setBackground(Color.white);
        this.add(menuI);
        menuP = new MenuProgram(v,menuI);
        new MenuProgram(v,menuI);

        JScrollPane scroll = new JScrollPane(menuP);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(scroll);
    }
}
