package org.Logica;

public class Cliente {
    private String nombre;
    private String rut;
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
}
