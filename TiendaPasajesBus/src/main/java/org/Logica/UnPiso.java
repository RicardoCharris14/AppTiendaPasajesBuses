package org.Logica;

import java.util.ArrayList;

public class UnPiso implements Pisos {
    private ArrayList<Asiento> asientosPiso1;
    private int nroAsientos;
    public UnPiso(int nroAsientos){
        asientosPiso1 = new ArrayList<>();
        this.nroAsientos = nroAsientos;
    }
    @Override
    public void setAsiento(Asiento asiento, int pisoAsiento){
        if(pisoAsiento == 1){
            asientosPiso1.add(asiento);
        }
    }
    @Override
    public Asiento getAsiento(int nroAsiento){
        if(nroAsiento > 0 && nroAsiento <= nroAsientos){
            return asientosPiso1.get(nroAsiento-1);
        }
        else{
            return null;
        }
    }
    @Override
    public int getNroAsientosPiso1(){
        return nroAsientos;
    }
    @Override
    public int getNroAsientosPiso2(){
        return 0;
    }
}
