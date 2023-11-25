package org.Logica;

public abstract class Bus {
    protected Pisos pisos;
    protected Recorrido recorrido;
    protected int valorPasaje;
    public Bus(Pisos nroPisos){
        recorrido = null;
        valorPasaje = 0;
        this.pisos = nroPisos;
    }
    public abstract Asiento getAsiento(int nroAsiento);
    public Recorrido getRecorrido(){
        return recorrido;
    }
    public void setRecorrido(Recorrido recorrido){
        this.recorrido = recorrido;
    }
    public void setValorPasaje(int valorPasaje){
        this.valorPasaje = valorPasaje;
    }
    public abstract String getTipoBus();
}
