package reserbus.model;

import java.sql.Time;
import java.util.Date;

public class Director {
    // opción: hacer multiples construct de distintos buses, que varíen en fecha y hora del viaje (constructBusSimpleNoche, constructBusDosPisosDia, etc.)
    public void constructBusSimpleDia(Builder builder, String inicio, String destino, Date fecha) {
        builder.setColor(Colors.BLUE);  // buses simples seran azules
        builder.setDosPisos(false);
        builder.setCantidadAsientos(20);
        builder.setFecha(fecha);
        builder.setLugarInicio(inicio);
        builder.setLugarDestino(destino);
        builder.setHoraInicio(new Time(10,00,00));
        builder.setHoraDestino(new Time(16,30,00));
    }

    public void constructBus2PisosDia(Builder builder, String lugarInicio, String lugarDestino, Date fecha) {
        builder.setColor(Colors.RED);   // buses dos pisos seran rojos
        builder.setDosPisos(true);
        builder.setCantidadAsientos(20); // 22 * 2 (por los dos pisos)
        builder.setFecha(fecha);
        builder.setLugarInicio(lugarInicio);
        builder.setLugarDestino(lugarDestino);
        builder.setHoraInicio(new Time(12,00,00));
        builder.setHoraDestino(new Time(19,30,00));
    }
}
