package Logica;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EmpresaBusesTest {
    @Test
    void pruebaSingleton(){
        EmpresaBuses Etm = EmpresaBuses.getEmpresaBuses(10);
        EmpresaBuses Eme = EmpresaBuses.getEmpresaBuses(20);
        assertSame(Etm,Eme);
    }
    @Test
    void pruebaAgregarBuses(){
        EmpresaBuses Etm = EmpresaBuses.getEmpresaBuses(15);
        Etm.addCiudadesAsociadas("Quellon");
        Etm.addCiudadesAsociadas("Castro");
        Bus bus1 = new BusSalonCama(new UnPiso(15));
        Etm.agregarBus(bus1,"Quellon","Castro", LocalDateTime.of(2023, Month.JUNE,15,10,0),10000);
        Etm.filtrarBuses("Quellon","Castro","2023-06-15");
        ArrayList<Bus> buses = Etm.getBusesItinerarioCliente();
        assertSame(bus1,buses.remove(0));
    }
    @Test
    void pruebaAgregarBusesMismoDia(){
        EmpresaBuses Etm = EmpresaBuses.getEmpresaBuses(15);
        Etm.addCiudadesAsociadas("Quellon");
        Etm.addCiudadesAsociadas("Castro");
        Bus bus1 = new BusSalonCama(new UnPiso(15));
        Etm.agregarBus(bus1,"Quellon","Castro", LocalDateTime.of(2023, Month.JUNE,15,10,0),10000);

        Etm.addCiudadesAsociadas("Quellon");
        Etm.addCiudadesAsociadas("Castro");
        Bus bus2 = new BusSalonCama(new UnPiso(15));
        Etm.agregarBus(bus2,"Quellon","Castro", LocalDateTime.of(2023, Month.JUNE,15,10,0),10000);

        Etm.addCiudadesAsociadas("Quellon");
        Etm.addCiudadesAsociadas("Castro");
        Bus bus3 = new BusSalonCama(new UnPiso(15));
        Etm.agregarBus(bus3,"Quellon","Castro", LocalDateTime.of(2023, Month.JUNE,15,10,0),10000);

        Etm.addCiudadesAsociadas("Quellon");
        Etm.addCiudadesAsociadas("Castro");
        Bus bus4 = new BusSalonCama(new UnPiso(15));
        Etm.agregarBus(bus4,"Quellon","Castro", LocalDateTime.of(2023, Month.JUNE,15,10,0),10000);

        Etm.addCiudadesAsociadas("Quellon");
        Etm.addCiudadesAsociadas("Castro");
        Bus bus5 = new BusSalonCama(new UnPiso(15));
        Etm.agregarBus(bus5,"Quellon","Castro", LocalDateTime.of(2023, Month.JUNE,15,10,0),10000);


    }
    @Test
    void comprarPasaje(){
        Cliente cliente = new Cliente("Ricardo", "22.066.527.5");
        EmpresaBuses Etm = EmpresaBuses.getEmpresaBuses(10);
        Bus bus = new BusSalonCama(new DosPisos(10,15));
        Etm.addCiudadesAsociadas("Quellon");
        Etm.addCiudadesAsociadas("Castro");
        Etm.agregarBus(bus,"Quellon","Castro", LocalDateTime.of(2023, Month.SEPTEMBER,15,20,0),5000);
        int[] asientos = {8,20};
        Pasaje pasaje = Etm.comprarPasaje(cliente, bus, asientos);
        assertEquals(pasaje.emitirPasaje(),"----------------------------------------------------\n" +
                "Fecha de salida: 15-09-2023 | 20:00 \n" +
                "Trayecto: Quellon - Castro\n" +
                "Clase de bus: Bus salon cama\n" +
                "Asientos: N°8 Piso 1 | N°20 Piso 2\n" +
                "----------------------------------------------------\n" +
                "Nombre: Ricardo\n" +
                "Rut: 22.066.527.5\n" +
                "Valor pasaje: 10000$\n" +
                "----------------------------------------------------");
    }
}