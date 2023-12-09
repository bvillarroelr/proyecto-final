package reserbus.model;

import java.sql.Time;
import java.util.Date;

public interface Builder {
    public void setColor(Colors c);
    public void setDosPisos(boolean b);
    public void setCantidadAsientos(int n);
    public void setFecha(Date f);
    public void setLugarInicio(String i);
    public void setLugarDestino(String d);
    public void setHoraInicio(Time inicio);
    public void setHoraDestino(Time destino);
}
