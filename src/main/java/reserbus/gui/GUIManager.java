package reserbus.gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GUIManager extends JPanel {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public GUIManager() {
            cardPanel.add(Panel1(), "Panel1");
            cardPanel.add(Panel2(), "Panel2");

            setLayout(new BorderLayout());
            add(cardPanel, BorderLayout.CENTER);
        }

        private JPanel Panel1() {
            JPanel panel = new JPanel();
            panel.add(new JLabel("Panel 1 Contenido"));
            return panel;
        }

        private JPanel Panel2() {
            JPanel panel = new JPanel();
            panel.add(new JLabel("Panel 2 Contenido"));
            return panel;
        }
}