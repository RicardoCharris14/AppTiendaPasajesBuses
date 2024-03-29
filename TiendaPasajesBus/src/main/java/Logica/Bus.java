package Logica;

/**
 * clase que representa un bus con un numero de pisos, un recorrido unico y un valor de pasaje
 * @author Vicente Ramirez
 * @author Ricardo Charris
 */
public abstract class Bus {
    private Pisos pisos;
    private Recorrido recorrido;
    private int valorPasaje;
    public Bus(Pisos nroPisos){
        recorrido = null;
        valorPasaje =0;
        this.pisos = nroPisos;
    }

    public Pisos getPisos() {
        return pisos;
    }

    public Recorrido getRecorrido(){
        return recorrido;
    }
    public void setRecorrido(Recorrido recorrido){
        this.recorrido = recorrido;
    }

    public int getValorPasaje() {
        return valorPasaje;
    }

    public void setValorPasaje(int valorPasaje){
        this.valorPasaje = valorPasaje;
    }
    public abstract Asiento getAsiento(int nroAsiento);
    public abstract String getTipoBus();
}