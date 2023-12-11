package Logica;

import Grafica.Ventana;

import java.time.LocalDateTime;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        EmpresaBuses EME = EmpresaBuses.getEmpresaBuses(10);

        BusPremium bus1 = new BusPremium(new DosPisos(10,15));
        BusSalonCama bus2 = new BusSalonCama(new UnPiso(20));
        BusPremium bus3 = new BusPremium(new DosPisos(5,20));
        BusPremium bus4 = new BusPremium(new UnPiso(10));
        BusPremium bus5 = new BusPremium(new DosPisos(18,4));
        BusPremium bus6 = new BusPremium(new UnPiso(15));

        EME.addCiudadesAsociadas("Quellón");
        EME.addCiudadesAsociadas("Concepción");
        EME.addCiudadesAsociadas("Villarica");
        EME.addCiudadesAsociadas("Rancagua");
        EME.addCiudadesAsociadas("Santiago");
        EME.addCiudadesAsociadas("Pucón");
        EME.addCiudadesAsociadas("Barranquilla");
        EME.addCiudadesAsociadas("Cartagena");

        EME.agregarBus(bus1, "Quellón","Concepción",LocalDateTime.of(2023,Month.JUNE,14,12,35),50000);
        EME.agregarBus(bus2,"Villarica","Concepción",LocalDateTime.of(2023,Month.MAY,25,18,45),30000);
        EME.agregarBus(bus3, "Rancagua","Concepción",LocalDateTime.of(2023,Month.JUNE,29,15,30),55000);
        EME.agregarBus(bus4, "Quellón","Villarica",LocalDateTime.of(2023,Month.MARCH,14,7, 0),40000);
        EME.agregarBus(bus5, "Quellón","Rancagua",LocalDateTime.of(2023,Month.DECEMBER,14,22,15),60000);
        EME.agregarBus(bus6, "Villarica","Quellón",LocalDateTime.of(2023,Month.JULY,28,23,59),70000);
        EME.agregarBus(bus4, "Quellón","Villarica",LocalDateTime.of(2023,Month.MARCH,11,7, 0),40000);
        EME.agregarBus(bus5, "Quellón","Rancagua",LocalDateTime.of(2023,Month.FEBRUARY,22,22,15),60000);
        EME.agregarBus(bus6, "Villarica","Quellón",LocalDateTime.of(2023,Month.APRIL,14,23,59),70000);

        Ventana ventana = new Ventana();
    }
}