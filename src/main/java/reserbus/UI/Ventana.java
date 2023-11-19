package reserbus.UI;
import javax.swing.*;

public class Ventana extends JFrame {
    private GUIManager gm;
    public Ventana() {
        gm = new GUIManager();
        this.add(gm);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Maquina Expendedora");
        this.setSize(1080, 720);
        this.setVisible(true);
    }
}