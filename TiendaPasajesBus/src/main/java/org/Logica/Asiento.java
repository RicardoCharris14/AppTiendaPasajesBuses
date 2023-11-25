package org.Logica;

public abstract class Asiento {
    protected int numAsiento;
    protected Boolean disponible;
    public Asiento(int numAsiento){
        this.numAsiento = numAsiento;
        this.disponible = true;
    }
    public int getNumAsiento(){
        return numAsiento;
    }
    public void setDisponible(Boolean disponible){
        this.disponible = disponible;
    }
}
