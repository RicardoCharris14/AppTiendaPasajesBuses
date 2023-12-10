package Logica;

import Grafica.Ventana;

import java.time.LocalDateTime;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        EmpresaBuses EME = EmpresaBuses.getEmpresaBuses(10);

        BusPremium bus1 = new BusPremium(new DosPisos(10,15));
        BusSalonCama bus2 = new BusSalonCama(new UnPiso(20));
        BusPremium bus3 = new BusPremium(new DosPisos(10,15));
        BusPremium bus4 = new BusPremium(new DosPisos(10,15));
        BusPremium bus5 = new BusPremium(new DosPisos(10,15));
        BusPremium bus6 = new BusPremium(new DosPisos(10,15));

        EME.addCiudadesAsociadas("Quellón");
        EME.addCiudadesAsociadas("Concepción");
        EME.addCiudadesAsociadas("Villarica");
        EME.addCiudadesAsociadas("Rancagua");

        EME.agregarBus(bus1, "Quellón","Concepción",LocalDateTime.of(2023,Month.JUNE,14,12,35),50000);
        EME.agregarBus(bus2,"Villarica","Concepción",LocalDateTime.of(2023,Month.JUNE,25,18,45),30000);
        EME.agregarBus(bus3, "Quellón","Concepción",LocalDateTime.of(2023,Month.JUNE,14,15,30),55000);
        EME.agregarBus(bus4, "Quellón","Concepción",LocalDateTime.of(2023,Month.JUNE,14,7, 0),40000);
        EME.agregarBus(bus5, "Quellón","Concepción",LocalDateTime.of(2023,Month.JUNE,14,22,15),60000);
        EME.agregarBus(bus6, "Quellón","Concepción",LocalDateTime.of(2023,Month.JUNE,14,23,59),70000);

        Cliente ricardo = new Cliente("Ricardo Charris", "22.066.527-5");
        System.out.println("El pasaje de ricardo es: \n");
        ricardo.comprarPasaje(EME,bus1,11);
        Cliente vicente = new Cliente("Vicente Ramirez","21.311.079-9");
        System.out.println("El pasaje de Vicente es: \n");
        vicente.comprarPasaje(EME,bus2,11);

        Ventana ventana = new Ventana();
    }
}