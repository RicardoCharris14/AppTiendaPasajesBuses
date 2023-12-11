package Logica;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PasajeTest {
    @Test
    void pruebaEmitirPasaje(){
        Cliente cliente = new Cliente("Ricardo", "22.066.527.5");
        Recorrido recorrido = new Recorrido("Quellon","Castro", LocalDateTime.of(2023, Month.SEPTEMBER,15,20,0));
        Bus bus = new BusSalonCama(new DosPisos(10,15));
        bus.setRecorrido(recorrido);
        bus.setValorPasaje(5000);
        ArrayList<Integer> asientos = new ArrayList<>();
        asientos.add(8);
        asientos.add(10);
        Pasaje pasaje = new Pasaje(cliente,bus,asientos);
        System.out.println(pasaje.emitirPasaje());
        assertEquals(pasaje.emitirPasaje(),"----------------------------------------------------\n" +
                "Fecha de salida: 15-09-2023 | 20:00 \n" +
                "Trayecto: Quellon - Castro\n" +
                "Clase de bus: Bus salon cama\n" +
                "Asientos: N°8 Piso 1 | N°10 Piso 1\n" +
                "----------------------------------------------------\n" +
                "Nombre: Ricardo\n" +
                "Rut: 22.066.527.5\n" +
                "Valor pasaje: 10000$\n" +
                "----------------------------------------------------");
    }
}