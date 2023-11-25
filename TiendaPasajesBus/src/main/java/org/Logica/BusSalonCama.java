package org.Logica;

public class BusSalonCama extends Bus{
    private String tipoBus;
    public BusSalonCama(Pisos pisos){
        super(pisos);
        tipoBus = "Bus salon cama";
        int nroAsientosPiso1 = pisos.getNroAsientosPiso1();
        int nroAsientosPiso2 = pisos.getNroAsientosPiso2();
        for(int i=1 ; i<=nroAsientosPiso1 ; i++){
            AsientoSalonCama asiento = new AsientoSalonCama(i);
            pisos.addAsiento(asiento, 1);
        }
        for(int i=nroAsientosPiso1+1 ; i<=nroAsientosPiso1+nroAsientosPiso2 ; i++){
            AsientoSalonCama asiento = new AsientoSalonCama(i);
            pisos.addAsiento(asiento, 2);
        }
    }
    @Override
    public Asiento getAsiento(int nroAsiento){
        return pisos.getAsiento(nroAsiento);
    }
    @Override
    public String getTipoBus() {
        return tipoBus;
    }
}