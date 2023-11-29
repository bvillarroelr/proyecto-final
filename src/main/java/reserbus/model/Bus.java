package reserbus.model;

import java.util.ArrayList;

public class Bus {
    private ArrayList<Asiento> listaAsientos;
    private int cantidadAsientos;
    private Colors color;
    private boolean dosPisos;
    public Bus(int cantidadAsientos, Colors color, boolean dosPisos) {
        this.color = color;
        this.dosPisos = dosPisos;
        listaAsientos = new ArrayList<Asiento>();
        for(int i = 0; i<cantidadAsientos; i++) {
            listaAsientos.add(new Asiento(i, TipoAsiento.NORMAL, 5000));
        }
    }
    public Asiento getAsiento(int id) {
        return listaAsientos.get(id);
    }
    public int getCantidadAsientos() {
        return this.cantidadAsientos;
    }
    public ArrayList<Asiento> getListaAsientos() {
        return listaAsientos;
    }

}
