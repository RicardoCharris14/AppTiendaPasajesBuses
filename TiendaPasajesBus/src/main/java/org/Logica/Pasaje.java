package org.Logica;

import java.util.Date;

public class Pasaje {
    private Date fechaSalida;
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
        if(pisoAsiento==1){
            piso = "Primer piso";
        }else{
            piso = "Segundo piso";
        }
        String pasaje = "--------------------------------------------\n" +
                        "Fecha de salida: "+fechaSalida.toString()+"\n" +
                        "Trayecto: "+origen+" - "+destino+"\n" +
                        "Clase de bus: "+tipoBus+"\n"+
                        "Numero de asiento: "+nroAsiento+"  |  Piso: "+piso+"\n"+
                        "--------------------------------------------\n" +
                        "Nombre: "+nombreCliente+"  |  Rut: "+rutCliente+"\n" +
                        "--------------------------------------------";
        return pasaje;
    }
}
