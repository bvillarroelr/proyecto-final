package reserbus.model;
// Clase padre que tendrá subclases de cada tipo de asiento
public class Asiento {
    private int id; // número del asiento
    private boolean disponible; // verifica si está disponible para reservar, o si ya está tomado (esto podría representarse por un color en la GUI)
    private Colors color;
    private TipoAsiento tipo;
    private float precio; 
    public Asiento(int id, TipoAsiento tipo, Colors color, int precio) {
        disponible = true;
        this.precio = precio;
        this.id = id;
        this.color = color;
        this.tipo = tipo;
    }
    public boolean getDisponible() {
        return this.disponible;
    }
    public void setDisponible(boolean s) {
        disponible = s;
    }
    public TipoAsiento getTipo(){
        return tipo;
    }
    public void setTipo(TipoAsiento t) {
        this.tipo = t;
    }
    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public void setID(int id) {
        this.id = id;
    }
    public int getID() {
        return id;
    }
}
