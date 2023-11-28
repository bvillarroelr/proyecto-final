package reserbus.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameAsientosBus extends JFrame implements ActionListener {
    private JButton volverAlMenu = new JButton("Volver");
    public FrameAsientosBus() {
        // Modificar layout si es necesario, solo lo hice de prueba por ahora
        this.setSize(460,460);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setTitle("Bus + (tipo de bus) + (destino)");
        this.add(new JLabel("TEST"));
        this.setVisible(true);

        this.add(volverAlMenu);
        volverAlMenu.setBounds(100,100,100,100);
        volverAlMenu.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == volverAlMenu) {
            // falta hacer logica para volver a la ventana anterior
        }
    }
}
