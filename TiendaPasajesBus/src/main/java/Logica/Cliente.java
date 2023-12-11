package Logica;

import java.util.ArrayList;

public class Cliente {
    private final String nombre;
    private final String rut;
    private Pasaje pasaje;
    public Cliente(String nombre, String rut){
        this.nombre = nombre;
        this.rut = rut;
    }
    public String getNombre(){
        return nombre;
    }
    public String getRut(){
        return rut;
    }
    public void comprarPasaje(EmpresaBuses empresa, Bus busSeleccionado, int[] nroAsiento){

        pasaje = empresa.comprarPasaje(this,busSeleccionado,nroAsiento);

    }
    public Pasaje getPasaje(){
        return pasaje;
    }
}
