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
        if(bus!=null){
            nroBuses+=1;
            Recorrido recorrido= new Recorrido(origen,destino,fecha);
            bus.setRecorrido(recorrido);
            buses.add(bus);
        }
    }
    public void retirarBus(int nroBus){
        buses.remove(nroBus-1);
    }
}
