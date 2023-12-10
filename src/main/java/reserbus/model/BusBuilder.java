package reserbus.model;


import java.sql.Time;
import java.util.Date;

public class BusBuilder implements Builder {
    private int cantidadAsientos;
    private Colors color;
    private boolean dosPisos;
    private String lugarInicio;
    private String lugarDestino;
    private Time horaInicio;
    private Time horaDestino;
    private Date fecha;
    @Override
    public void setColor(Colors color) {
        this.color = color;
    }

    @Override
    public void setDosPisos(boolean b) {
        this.dosPisos = b;
    }

    @Override
    public void setCantidadAsientos(int n) {
        this.cantidadAsientos = n;
    }

    @Override
    public void setFecha(Date f) {
        this.fecha = f;
    }

    @Override
    public void setLugarInicio(String i) {
        this.lugarInicio = i;
    }

    @Override
    public void setLugarDestino(String d) {
        this.lugarDestino = d;
    }
    @Override
    public void setHoraInicio(Time i) {
        this.horaInicio = i;
    }
    @Override
    public void setHoraDestino(Time d) {
        this.horaDestino = d;
    }

    /**
     * Una vez construido por la clase directora, retorna el resultado final como un nuevo objeto Bus.
     * @return
     */
    public Bus getResult() {
        return new Bus(cantidadAsientos, color, dosPisos, lugarInicio, lugarDestino, fecha, horaInicio, horaDestino);
    }

}