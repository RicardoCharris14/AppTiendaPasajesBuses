package Logica;

import Grafica.Ventana;

import java.time.LocalDateTime;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        BusPremium bus1 = new BusPremium(new DosPisos(10,15));
        BusSalonCama bus2 = new BusSalonCama(new UnPiso(20));
        EmpresaBuses EME = new EmpresaBuses(3);

        EME.addCiudadesAsociadas("Quellón");
        EME.addCiudadesAsociadas("Concepción");
        EME.addCiudadesAsociadas("Villarica");
        EME.addCiudadesAsociadas("Rancagua");

        EME.agregarBus(bus1, "Quellón","Concepción",LocalDateTime.of(2023,Month.JUNE,14,12,35),50000);
        EME.agregarBus(bus2,"Villarica","Concepción",LocalDateTime.of(2023,Month.JUNE,25,18,45),30000);

        Ventana ventana = new Ventana(EME);

        Cliente ricardo = new Cliente("Ricardo Charris", "22.066.527-5");
        System.out.println("El pasaje de ricardo es: \n");
        ricardo.comprarPasaje(EME,1,11);
        Cliente vicente = new Cliente("Vicente Ramirez","21.311.079-9");
        System.out.println("El pasaje de Vicente es: \n");
        vicente.comprarPasaje(EME,2,11);
    }
}