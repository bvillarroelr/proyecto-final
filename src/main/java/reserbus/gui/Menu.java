package reserbus.gui;

import javax.swing.*;
import java.awt.*;
// Menu Principal
public class Menu extends JPanel {
    MenuInfo menuI = new MenuInfo();
    MenuProgram menuP;
    public Menu(Ventana v) {    // Recibe parámetro Ventana para asignarselo a menuP (para poder trabajar con los Listeners y abrir otras ventanas)
        menuP = new MenuProgram(v);
        new MenuProgram(v);
        this.setLayout(new GridLayout(1,2));
        this.setBackground(Color.white);
        this.add(menuI);

        JScrollPane scroll = new JScrollPane(menuP);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(scroll);
    }
    public MenuInfo getMenuI() {
        return menuI;
    }

    public void setMenuI(MenuInfo menuI) {
        this.menuI = menuI;
    }

    public MenuProgram getMenuP() {
        return menuP;
    }

    public void setMenuP(MenuProgram menuP) {
        this.menuP = menuP;
    }
}
