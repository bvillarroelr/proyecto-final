package reserbus.model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Bus {
    private ArrayList<Asiento> listaAsientos;
    private int cantidadAsientos;
    private Colors color;
    private boolean dosPisos;
    private String lugarInicio;
    private String lugarDestino;
    private Time horaInicio;
    private Time horaDestino;
    private Date fecha;
    public Bus(int cantidadAsientos, Colors color, boolean dosPisos, String lugarInicio, String lugarDestino, Date fecha, Time horaInicio, Time horaDestino) {
        this.cantidadAsientos = cantidadAsientos;
        this.color = color;
        this.dosPisos = dosPisos;
        this.fecha = fecha;
        this.lugarInicio = lugarInicio;
        this.lugarDestino = lugarDestino;
        this.horaInicio = horaInicio;
        this.horaDestino = horaDestino;
        if(dosPisos) {
            cantidadAsientos = cantidadAsientos*2; // pisos en ambas plantas del bus
        }
        listaAsientos = new ArrayList<Asiento>();
        for(int i = 0; i<cantidadAsientos; i++) {
            if(i < 7) { // esto hará que los primeros 8 asientos sean SEMICAMA.
                listaAsientos.add(new Asiento(i, TipoAsiento.SEMICAMA, Colors.YELLOW, 6000));
            }
            else {
                listaAsientos.add(new Asiento(i, TipoAsiento.NORMAL, Colors.RED, 5000));
            }
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

    public String getLugarInicio() {
        return lugarInicio;
    }

    public String getLugarDestino() {
        return lugarDestino;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public Time getHoraDestino() {
        return horaDestino;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "lugarInicio='" + lugarInicio + '\'' +
                ", lugarDestino='" + lugarDestino + '\'' +
                ", horaInicio=" + horaInicio +
                ", horaDestino=" + horaDestino +
                ", fecha=" + fecha +
                '}';
    }
}
