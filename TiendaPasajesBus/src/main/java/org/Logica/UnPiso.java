package org.Logica;

import java.util.ArrayList;

public class UnPiso implements Pisos {
    ArrayList<Asiento> asientosPiso1;
    public UnPiso(){
        asientosPiso1 = new ArrayList<>();
    }
    @Override
    public void setAsiento(Asiento asiento, int pisoAsiento){
        asientosPiso1.add(asiento);
    }
    @Override
    public Asiento getAsiento(int NroAsiento){
        return asientosPiso1.get(NroAsiento-1);
    }
}
