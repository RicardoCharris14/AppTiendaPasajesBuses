package org.Logica;

public abstract class Bus {
    protected Pisos pisos;
    protected Recorrido recorrido;
    public Bus(Pisos nroPisos, Recorrido recorrido){
        this.pisos = nroPisos;
        this.recorrido = recorrido;
    }
    public abstract Asiento getAsiento(int nroAsiento);
}
