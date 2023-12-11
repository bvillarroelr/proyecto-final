package reserbus.model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * Clase que representa a un bus, posee información del viaje como los inicios y destinos, junto con los asientos y fechas.
 */
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

    /**
     * Constructor. Crea un bus con los parámetros entregados.
     * @param cantidadAsientos
     * @param color
     * @param dosPisos
     * @param lugarInicio
     * @param lugarDestino
     * @param fecha
     * @param horaInicio
     * @param horaDestino
     */

    public Bus(int cantidadAsientos, Colors color, boolean dosPisos, String lugarInicio, String lugarDestino, Date fecha, Time horaInicio, Time horaDestino) {
        this.cantidadAsientos = cantidadAsientos;
        this.color = color;
        this.dosPisos = dosPisos;
        this.fecha = fecha;
        this.lugarInicio = lugarInicio;
        this.lugarDestino = lugarDestino;
        this.horaInicio = horaInicio;
        this.horaDestino = horaDestino;
        listaAsientos = new ArrayList<Asiento>();
        for(int i = 0; i<cantidadAsientos; i++) {
            if(i < 9) {
                listaAsientos.add(new Asiento(i, TipoAsiento.SEMICAMA, Colors.YELLOW, 6000));
            }
            else {
                listaAsientos.add(new Asiento(i, TipoAsiento.NORMAL, Colors.RED, 5000));
            }
        }
        if(dosPisos) {
            int totalAsientos = listaAsientos.size();
            for(int i = totalAsientos - 8; i < totalAsientos; i++) {
                listaAsientos.get(i).setTipo(TipoAsiento.CAMA);
            }
        }
        asientosRandomizer();
    }
    public Asiento getAsiento(int id) {
        return listaAsientos.get(id);
    }
    public void asientosRandomizer() {
        Random random = new Random();
        for(int i = 0; i<cantidadAsientos/2; i++) {     // la mitad de los asientos estarán ocupados
            int x = random.nextInt(cantidadAsientos);
            listaAsientos.get(x).setDisponible(false);
        }
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
