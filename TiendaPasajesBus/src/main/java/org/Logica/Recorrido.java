package org.Logica;

import java.util.Date;

public class Recorrido {
    private Date fechaSalida;
    private String origen;
    private String destino;
    public Recorrido(String origen, String destino, Date fechaSalida){
        this.fechaSalida = fechaSalida;
        this.origen = origen;
        this.destino = destino;
    }
    public String getDatosRecorrido(){
        return "Fecha de salida: "+fechaSalida.toString()+"\nTrayecto: "+origen+" - "+destino+"\n";
    }
    public String getOrigen(){
        return origen;
    }
    public String getDestino(){
        return destino;
    }
    public Date getFechaSalida(){
        return fechaSalida;
    }

}
