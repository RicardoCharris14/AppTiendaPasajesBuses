package Logica;

import java.util.ArrayList;

public class Cliente {
    private final String nombre;
    private final String rut;
    private ArrayList<Pasaje> pasaje;
    public Cliente(String nombre, String rut){
        pasaje = new ArrayList<>();

        this.nombre = nombre;
        this.rut = rut;
    }
    public String getNombre(){
        return nombre;
    }
    public String getRut(){
        return rut;
    }
    public void comprarPasaje(EmpresaBuses empresa, Bus busSeleccionado, int nroAsiento){
        try{
            pasaje.add(empresa.comprarPasaje(this,busSeleccionado,nroAsiento));
        }catch (AsientoOcupadoException e){
            System.out.println("\n"+e.getMessage());
        }
    }
    public Pasaje getPasaje(int nPasaje){
        return pasaje.get(nPasaje-1);
    }
}
