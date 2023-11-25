package org.Logica;

import java.util.Date;

public class Pasaje {
    private Date fechaSalida;
    private String origen;
    private String destino;
    private String nombreCliente;
    private String rutCliente;
    private int nroAsiento;
    private int pisoAsiento;
    public Pasaje(Cliente cliente, Bus bus){
        fechaSalida = bus.getRecorrido().getFechaSalida();
        origen = bus.getRecorrido().getOrigen();
        destino = bus.getRecorrido().getDestino();
        nombreCliente = cliente.getNombre();
        rutCliente = cliente.getRut();
        if(bus.pisos.getNroAsientosPiso1()-nroAsiento>=0){
            pisoAsiento = 1;
        }
        else{
            pisoAsiento = 2;
        }
    }
    public String emitirPasaje(){
        String pasaje = "--------------------------------------------\n" +
                        "Fecha de salida: "+fechaSalida.toString()+"\n" +
                        "Trayecto: "+origen+" - "+destino+"\n" +
                        "Numero de asiento: "+"  |  "+pisoAsiento+"\n"+
                        "--------------------------------------------\n" +
                        "Nombre: "+nombreCliente+"  |  Rut: "+rutCliente+"\n" +
                        "--------------------------------------------";
        return pasaje;
    }
}
