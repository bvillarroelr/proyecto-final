package reserbus.model;

import java.util.ArrayList;

public class Reserva {
    private Bus b;
    private ArrayList<Asiento> asientos;    // es un arraylist porque la reserva puede ser de múltiples asientos.
    private float precioTotal;
    public Reserva(Bus b) {
        this.b = b;
        asientos = new ArrayList<Asiento>();
    }
    public void addAsiento(Asiento a) {
        asientos.add(a);
    }
    public void removeAsiento(Asiento asiento) {
        asientos.remove(asiento);
    }
    public ArrayList<Asiento> getAsientos() {
        return asientos;
    }
    public void clear() {
        asientos.clear();
    }

    /**
     * Calcula y retorna el precio total a pagar, considerando la lista de reservas del cliente y el precio de cada asiento almacenado en esta.
     * @return
     */
    public float calculaPrecioTotal() {
        int n = asientos.size();
        precioTotal = 0;

        for(int i = 0; i < n; i++) {
            precioTotal += asientos.get(i).getPrecio();
        }
        return precioTotal;
    }
}
