package org.Logica;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pasaje {
    private LocalDateTime fechaSalida;
    private String origen;
    private String destino;
    private String nombreCliente;
    private String rutCliente;
    private String tipoBus;
    private int nroAsiento;
    private int pisoAsiento;
    public Pasaje(Cliente cliente, Bus bus, int nroAsiento){
        fechaSalida = bus.getRecorrido().getFechaSalida();
        origen = bus.getRecorrido().getOrigen();
        destino = bus.getRecorrido().getDestino();
        nombreCliente = cliente.getNombre();
        rutCliente = cliente.getRut();
        tipoBus = bus.getTipoBus();
        this.nroAsiento = nroAsiento;
        if(bus.getPisos().getNroAsientosPiso1()-nroAsiento>=0){
            pisoAsiento = 1;
        }
        else{
            pisoAsiento = 2;
        }
    }
    public String emitirPasaje(){
        String piso;
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy | HH:mm ");
        String fecha = fechaSalida.format(formatoFecha);
        if(pisoAsiento==1){
            piso = "Primer piso";
        }else{
            piso = "Segundo piso";
        }
        String pasaje = "----------------------------------------------\n" +
                        "Fecha de salida: "+fecha+"\n" +
                        "Trayecto: "+origen+" - "+destino+"\n" +
                        "Clase de bus: "+tipoBus+"\n"+
                        "Numero de asiento: "+nroAsiento+"  |  Piso: "+piso+"\n"+
                        "----------------------------------------------\n" +
                        "Nombre: "+nombreCliente+"  |  Rut: "+rutCliente+"\n" +
                        "Valor pasaje: "
                        +"----------------------------------------------";
        return pasaje;
    }
}
