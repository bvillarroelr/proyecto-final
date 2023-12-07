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
    public Bus(int cantidadAsientos, Colors color, boolean dosPisos, String inicio, String destino, Date fecha) {
        this.cantidadAsientos = cantidadAsientos;
        this.color = color;
        this.dosPisos = dosPisos;
        this.fecha = fecha;
        listaAsientos = new ArrayList<Asiento>();
        for(int i = 0; i<cantidadAsientos; i++) {
            listaAsientos.add(new Asiento(i, TipoAsiento.NORMAL, Colors.RED, 5000));
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
    public ArrayList<Asiento> getListaAsientos() {
        return listaAsientos;
    }

    public boolean isDosPisos() {
        return dosPisos;
    }

    public Date getFecha() {
        return this.fecha;
    }
}
