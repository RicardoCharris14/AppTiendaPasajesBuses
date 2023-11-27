package Logica;

import java.time.LocalDateTime;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        BusPremium bus1 = new BusPremium(new DosPisos(10,15));
        BusSalonCama bus2 = new BusSalonCama(new UnPiso(20));
        EmpresaBuses ETM = new EmpresaBuses(3);
        ETM.agregarBus(bus1, "Quellon","Concepcion",LocalDateTime.of(2023,Month.JUNE,14,12,35),50000);
        ETM.agregarBus(bus2,"Villarica","Concepcion",LocalDateTime.of(2023,Month.JUNE,25,18,45),30000);
        Cliente ricardo = new Cliente("Ricardo Charris", "22.066.527-5");
        System.out.println("El pasaje de ricardo es: \n");
        ricardo.comprarPasaje(ETM,1,11);
        Cliente vicente = new Cliente("Vicente Ramirez","21.311.079-9");
        vicente.comprarPasaje(ETM,1,11);
        System.out.println("El pasaje de Vicente es: \n");
        vicente.comprarPasaje(ETM,1,10);

    }
}