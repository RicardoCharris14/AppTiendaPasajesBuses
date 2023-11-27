package Logica;

import java.time.LocalDateTime;

public class Recorrido {
    private LocalDateTime fechaSalida;
    private String origen;
    private String destino;
    public Recorrido(String origen, String destino, LocalDateTime fechaSalida){
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
    public LocalDateTime getFechaSalida(){
        return fechaSalida;
    }

}
