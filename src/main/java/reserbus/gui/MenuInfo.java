package reserbus.gui;

import reserbus.model.*;
import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa la sección de bienvenida y maneja la aparicion de MenuBusInfo.
 */
public class MenuInfo extends JPanel {
    private Bus b;
    private JLabel info;
    private MenuBusInfo mbi;
    private JPanel actual = new JPanel();

    /**
     * Constructor de la clase MenuInfo.
     */
    public MenuInfo() {
        setLayout(new BorderLayout());
        info = new JLabel("Bienvenido a Reserbus");
        info.setPreferredSize(new Dimension(300, 100));
        info.setHorizontalAlignment(JLabel.CENTER);
        info.setVerticalAlignment(JLabel.CENTER);
        info.setFont(new Font("Arial", Font.BOLD, 18));
        this.add(info, BorderLayout.NORTH);
        this.add(actual, BorderLayout.CENTER);
    }

    /**
     * Cambia la información segun el bus seleccionado.
     *
     * @param f Panel con la nueva información.
     */
    public void changeBus(JPanel f) {
        remove(actual);
        add(f);
        actual = f;
        revalidate();
        repaint();
    }
}
