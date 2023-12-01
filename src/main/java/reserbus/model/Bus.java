package reserbus.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class Bus {
    private ArrayList<Asiento> listaAsientos;
    private int cantidadAsientos;
    private Colors color;
    private boolean dosPisos;
    private String inicio;
    private String destino;
    private Date fecha;
    public Bus(int cantidadAsientos, Colors color, boolean dosPisos, String inicio, String destino) {
        this.color = color;
        this.dosPisos = dosPisos;
        listaAsientos = new ArrayList<Asiento>();
        for(int i = 0; i<cantidadAsientos; i++) {
            listaAsientos.add(new Asiento(i, TipoAsiento.NORMAL, Colors.RED));
        }
    }
    public Asiento getAsiento(int id) {
        return listaAsientos.get(id);
    }

    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    public int getCantidadAsientos() {
        return this.cantidadAsientos;
    }
    public void setCantidadAsientos(int cantidadAsientos) {
        this.cantidadAsientos = cantidadAsientos;
    }
    public ArrayList<Asiento> getListaAsientos() {
        return listaAsientos;
    }

    public boolean isDosPisos() {
        return dosPisos;
    }

    public void setDosPisos(boolean dosPisos) {
        this.dosPisos = dosPisos;
    }
}
