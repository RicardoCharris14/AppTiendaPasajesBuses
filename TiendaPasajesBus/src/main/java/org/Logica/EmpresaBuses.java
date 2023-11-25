package org.Logica;

import java.util.ArrayList;
import java.util.Date;

public class EmpresaBuses {
    private int nroBuses;
    private int capacidadBuses;
    private ArrayList<Bus> buses;
    public EmpresaBuses(int capacidadBuses){
        nroBuses = 0;
        this.capacidadBuses = capacidadBuses;
        buses = new ArrayList<>();
    }
    public void agregarBus(Bus bus,String origen, String destino, Date fecha, int precio){
        if(bus!=null && buses.size()<capacidadBuses){
            nroBuses+=1;
            Recorrido recorrido= new Recorrido(origen,destino,fecha);
            bus.setRecorrido(recorrido);
            buses.add(bus);
        }
    }
    public void retirarBus(int nroBus){
        buses.remove(nroBus-1);
    }
    public Pasaje comprarPasaje(Cliente cliente, int nroBus, int nroAsiento)throws AsientoOcupadoException{
        if(nroBus>0 && nroBus<=nroBuses){
            Bus busSolicitado = buses.get(nroBus+1);
            Asiento asientoSolicitado = busSolicitado.getAsiento(nroAsiento);
            if(asientoSolicitado!= null){
                if(asientoSolicitado.getDisponible()){
                    asientoSolicitado.setDisponible(false);
                    Pasaje pasaje = new Pasaje(cliente, busSolicitado, asientoSolicitado.getNumAsiento());
                    System.out.println("\n"+pasaje.emitirPasaje());
                    return pasaje;
                }
                else{
                    throw new AsientoOcupadoException("El asiento no está disponible.");
                }
            }
            else{
                return null;
            }
        }
        else{
            return null;
        }
    }
}