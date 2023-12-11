package Logica;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {
    @Test
    void creacionCliente(){
        Cliente cliente = new Cliente("Ricardo","22.066.527-5");
        assertEquals(cliente.getNombre(), "Ricardo");
        assertEquals(cliente.getRut(),"22.066.527-5");
    }
    @Test
    void compraDePasaje(){
        Cliente cliente = new Cliente("Ricardo", "22.066.527.5");
        EmpresaBuses Etm = EmpresaBuses.getEmpresaBuses(10);
        Bus bus = new BusSalonCama(new DosPisos(10,15));
        Etm.addCiudadesAsociadas("Quellon");
        Etm.addCiudadesAsociadas("Castro");
        Etm.agregarBus(bus,"Quellon","Castro", LocalDateTime.of(2023, Month.SEPTEMBER,15,20,0),5000);
        int[] asientos = {10,11};
        cliente.comprarPasaje(Etm,bus,asientos);
        assertFalse(bus.getAsiento(10).getDisponible());
        assertFalse(bus.getAsiento(11).getDisponible());
        assertTrue(bus.getAsiento(16).getDisponible());
    }


}