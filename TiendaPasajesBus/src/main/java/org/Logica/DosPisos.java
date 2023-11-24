package org.Logica;

import java.util.ArrayList;

public class DosPisos implements Pisos {
    ArrayList<Asiento> asientosPiso1;
    ArrayList<Asiento> asientosPiso2;
    int nroAsientosPiso1;
    int nroAsientosPiso2;
    public DosPisos(int nroAsientosPiso1, int nroAsientosPiso2){
        asientosPiso1 = new ArrayList<>();
        asientosPiso2 = new ArrayList<>();
        this.nroAsientosPiso1 = nroAsientosPiso1;
        this.nroAsientosPiso2 = nroAsientosPiso2;
    }

    @Override
    public void addAsiento(Asiento asiento, int pisoAsiento) {
        if(pisoAsiento == 1){
            asientosPiso1.add(asiento);
        }
        else if(pisoAsiento == 2){
            asientosPiso2.add(asiento);
        }
    }

    @Override
    public Asiento getAsiento(int NroAsiento) {
        if (NroAsiento <= nroAsientosPiso1 && NroAsiento>0){
            return asientosPiso1.get(NroAsiento-1);
        }
        else if(NroAsiento > nroAsientosPiso1 && NroAsiento<=nroAsientosPiso1+nroAsientosPiso2){
            return asientosPiso2.get(NroAsiento-nroAsientosPiso1-1);
        }
        else{
            return null;
        }
    }
    @Override
    public int getNroAsientosPiso1(){
        return nroAsientosPiso1;
    }

    @Override
    public int getNroAsientosPiso2() {
        return nroAsientosPiso2;
    }
}
