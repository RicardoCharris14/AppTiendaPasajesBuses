package org.Logica;

public abstract class Asiento {
    private int numAsiento;
    private Boolean disponible;
    public Asiento(int numAsiento){
        this.numAsiento = numAsiento;
        this.disponible = true;
    }
    public int getNumAsiento(){
        return numAsiento;
    }
    public Boolean getDisponible(){
        return disponible;
    }
    public void setDisponible(Boolean disponible){
        this.disponible = disponible;
    }
}
