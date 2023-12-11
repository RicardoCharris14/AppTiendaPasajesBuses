package Logica;

import java.util.ArrayList;

/**
 * clase que sirve para crear un bus con un piso
 * @author Vicente Ramirez
 * @author Ricardo Charris
 */
public class UnPiso implements Pisos {
    private ArrayList<Asiento> asientosPiso1;
    private int nroAsientos;
    public UnPiso(int nroAsientos){
        asientosPiso1 = new ArrayList<>();
        this.nroAsientos = Math.min(nroAsientos,18);
    }

    /**
     * anade un asiento al piso
     * @param asiento asiento a anadir
     * @param pisoAsiento piso en el que se agregara el asiento
     */
    @Override
    public void addAsiento(Asiento asiento, int pisoAsiento){
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
    @Override
    public int getNroPisos(){
        return 1;
    }
}