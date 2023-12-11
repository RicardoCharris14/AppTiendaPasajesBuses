package Logica;

import java.time.LocalDateTime;

/**
 * clase que contiene los datos de un recorrido, especificamente, el origen, destino y fecha de salida
 * @author Vicente Ramirez
 * @author Ricardo Charris
 */
public class Recorrido {
    private LocalDateTime fechaSalida;
    private String origen;
    private String destino;
    public Recorrido(String origen, String destino, LocalDateTime fechaSalida){
        this.fechaSalida = fechaSalida;
        this.origen = origen;
        this.destino = destino;
    }

    /**
     * crea una String con los datos del recorrido ordenados de forma ordenada
     * @return String con los datos del recorido
     */
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
