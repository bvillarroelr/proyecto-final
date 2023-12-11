package reserbus.model;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class BuilderTest {
    @Test
    public void buildBusSimpleTest(){
        // Construimos el bus de 1 piso
        BusBuilder buildernormal = new BusBuilder();
        Director director = new Director();
        director.constructBusSimpleDia(buildernormal, "Concepcion", "Santiago", new Date(2023,12,25));
        Bus b = buildernormal.getResult();
        // Verificamos los parámetros del bus, y que coincidan con los esperados
        assertFalse(b.isDosPisos());
        assertEquals(new Date(2023,12,25), b.getFecha());
        assertEquals(Colors.BLUE, b.getColor());
        assertEquals(21, b.getCantidadAsientos());
        System.out.println(b);
    }
    @Test
    public void buildBusDosPisosTest() {
        // Construimos bus de 2 pisos
        BusBuilder builderDosPisos = new BusBuilder();
        Director director = new Director();
        director.constructBus2PisosDia(builderDosPisos, "Talca", "Valparaiso", new Date(2024,01,01));
        Bus b = builderDosPisos.getResult();
        // Verficiamos los parámetros del bus, y que coincidan con los esperados
        assertTrue(b.isDosPisos());
        assertEquals(new Date(2024,1,1), b.getFecha());
        assertEquals(Colors.RED, b.getColor());
        assertEquals(41, b.getCantidadAsientos());
    }
}