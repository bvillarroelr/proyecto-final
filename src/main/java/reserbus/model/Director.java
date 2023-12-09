package reserbus.model;

import java.util.Date;

public class Director {
    // opción: hacer multiples construct de distintos buses, que varíen en fecha y hora del viaje (constructBusSimpleNoche, constructBusDosPisosDia, etc.)
    public void constructBusSimple(Builder builder, String inicio, String destino, Date fecha) {
        builder.setColor(Colors.BLUE);  // buses simples seran azules
        builder.setDosPisos(false);
        builder.setCantidadAsientos(22);
        builder.setFecha(fecha);
        builder.setLugarInicio(inicio);
        builder.setLugarDestino(destino);
        // falta agregar horas
    }

    public void constructBus2Pisos(Builder builder, String inicio, String destino, Date fecha) {
        builder.setColor(Colors.RED);   // buses dos pisos seran rojos
        builder.setDosPisos(true);
        builder.setCantidadAsientos(22); // 22 * 2 (por los dos pisos)
        builder.setFecha(fecha);
        builder.setLugarInicio(inicio);
        builder.setLugarDestino(destino);
        // falta agregar horas
    }
}
