    package reserbus.gui;

    import javax.swing.*;
    import java.awt.*;

    public class Ventana extends JFrame {
        BusFrame a;
        private Menu m = new Menu(this);
        public Ventana() {
            setLayout(new BorderLayout());
            add(m,BorderLayout.CENTER);
            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setTitle("Sistema reserbus");
            setSize(1080, 720);
            setVisible(true);
            setLocationRelativeTo(null);
        }
        public void switchPanel(JPanel panel){

        }
    }
