package Logica;

/**
 * clase que se usa para construir el bus
 * @author Vicente Ramirez
 * @author Ricardo Charris
 */
public interface Pisos {
    void addAsiento(Asiento asiento, int pisoAsiento);
    Asiento getAsiento(int NroAsiento);
    int getNroAsientosPiso1();
    int getNroAsientosPiso2();
    int getNroPisos();
}