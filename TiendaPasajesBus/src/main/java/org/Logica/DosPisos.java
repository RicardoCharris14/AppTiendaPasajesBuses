package org.Logica;

import java.util.ArrayList;

public class DosPisos implements Pisos {
    ArrayList<Asiento> asientosPiso1;
    ArrayList<Asiento> asientosPiso2;
    public DosPisos(){
        asientosPiso1 = new ArrayList<>();
        asientosPiso2 = new ArrayList<>();
    }

    @Override
    public void setAsiento(Asiento asiento, int pisoAsiento) {
        if(pisoAsiento == 1){
            asientosPiso1.add(asiento);
        }
        else if(pisoAsiento == 2){
            asientosPiso2.add(asiento);
        }
    }

    @Override
    public Asiento getAsiento(int NroAsiento) {
        if (NroAsiento <= 10 && NroAsiento>0){
            return asientosPiso1.get(NroAsiento-1);
        }
        else{
            return asientosPiso2.get(NroAsiento-11);
        }
    }
}
