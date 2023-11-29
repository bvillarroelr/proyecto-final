package reserbus.model;
// Clase padre que tendrá subclases de cada tipo de asiento
public class Asiento {
    private int id; // número del asiento
    protected boolean disponible; // verifica si está disponible para reservar, o si ya está tomado (esto podría representarse por un color en la GUI)
    private Colors color;
    private TipoAsiento tipo;
    private float precio;
    public Asiento(int id, TipoAsiento tipo, float precio) {
        disponible = true;
        this.id = id;
        this.color = color;
        this.tipo = tipo;
        this.precio = precio;
    }
    public boolean getDisponible() {
        return this.disponible;
    }
    public void setDisponible(boolean s) {
        disponible = s;
    }
}
