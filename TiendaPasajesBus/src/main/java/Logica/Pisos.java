package Logica;

public interface Pisos {
    void addAsiento(Asiento asiento, int pisoAsiento);
    Asiento getAsiento(int NroAsiento);
    int getNroAsientosPiso1();
    int getNroAsientosPiso2();
    int getNroPisos();
}