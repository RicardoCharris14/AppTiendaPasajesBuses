package org.Logica;

public class BusPremium extends Bus{
    public BusPremium(Pisos pisos, Recorrido recorrido){
        super(pisos, recorrido);
        int nroAsientosPiso1 = pisos.getNroAsientosPiso1();
        int nroAsientosPiso2 = pisos.getNroAsientosPiso2();
        for(int i=1 ; i<=nroAsientosPiso1 ; i++){
            AsientoPremium asiento = new AsientoPremium(i);
            pisos.addAsiento(asiento,1);
        }
        for(int i=nroAsientosPiso1+1 ; i<=nroAsientosPiso1+nroAsientosPiso2 ; i++){
            AsientoPremium asiento = new AsientoPremium(i);
            pisos.addAsiento(asiento, 2);
        }
    }
    @Override
    public Asiento getAsiento(int nroAsiento){
        return pisos.getAsiento(nroAsiento);
    }
}