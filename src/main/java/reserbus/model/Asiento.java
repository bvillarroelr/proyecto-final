package reserbus.model;
// Clase padre que tendrá subclases de cada tipo de asiento
public class Asiento {
    private int id; // número del asiento
    protected boolean disponible; // verifica si está disponible para reservar, o si ya está tomado (esto podría representarse por un color en la GUI)
    private String color;
    private String tipo;
    private float precio;
    public Asiento(int id) {
        disponible = true;
        this.id = id;
    }
    public boolean getDisponible() {
        return this.disponible;
    }
    public void setDisponible(boolean s) {
        disponible = s;
    }
}
