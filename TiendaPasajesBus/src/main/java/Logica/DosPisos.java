package Logica;

import java.util.ArrayList;

/**
 * clase que se utiliza para crear un bus con 2 pisos
 * @author Vicente Ramirez
 * @author Ricardo Charris
 */
public class DosPisos implements Pisos {
    ArrayList<Asiento> asientosPiso1;
    ArrayList<Asiento> asientosPiso2;
    int nroAsientosPiso1;
    int nroAsientosPiso2;

    /**
     * inicializa las componentes
     * @param nroAsientosPiso1 numero de asientos que habran en el primer piso
     * @param nroAsientosPiso2 numero de asientos que habran en el segundo piso
     */
    public DosPisos(int nroAsientosPiso1, int nroAsientosPiso2){
        asientosPiso1 = new ArrayList<>();
        asientosPiso2 = new ArrayList<>();
        this.nroAsientosPiso1 = Math.min(nroAsientosPiso1,18);
        this.nroAsientosPiso2 = Math.min(nroAsientosPiso2,18);
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

    @Override
    public int getNroPisos() {
        return 2;
    }
}