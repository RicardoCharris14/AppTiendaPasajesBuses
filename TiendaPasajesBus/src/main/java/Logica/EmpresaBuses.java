package Logica;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class EmpresaBuses {
    private ArrayList<String> ciudadesAsociadas;
    private int nroBuses;
    private int capacidadBuses;
    private ArrayList<Bus> buses;
    public EmpresaBuses(int capacidadBuses){
        ciudadesAsociadas = new ArrayList<>();
        nroBuses = 0;
        this.capacidadBuses = capacidadBuses;
        buses = new ArrayList<>();
    }
    public void agregarBus(Bus bus, String origen, String destino, LocalDateTime fecha, int precio){
        if(bus!=null && buses.size()<capacidadBuses){
            if(ciudadesAsociadas.contains(origen) && ciudadesAsociadas.contains(destino)){
                nroBuses+=1;
                Recorrido recorrido= new Recorrido(origen,destino,fecha);
                bus.setRecorrido(recorrido);
                bus.setValorPasaje(precio);
                buses.add(bus);
            }

        }
    }
    public void retirarBus(int nroBus){
        buses.remove(nroBus-1);
    }
    public Pasaje comprarPasaje(Cliente cliente, int nroBus, int nroAsiento)throws AsientoOcupadoException{
        if(nroBus>0 && nroBus<=nroBuses){
            Bus busSolicitado = buses.get(nroBus-1);
            Asiento asientoSolicitado = busSolicitado.getAsiento(nroAsiento);
            if(asientoSolicitado!= null){
                if(asientoSolicitado.getDisponible()){
                    asientoSolicitado.setDisponible(false);
                    Pasaje pasaje = new Pasaje(cliente, busSolicitado, asientoSolicitado.getNumAsiento());
                    System.out.println(pasaje.emitirPasaje());
                    return pasaje;
                }
                else{
                    throw new AsientoOcupadoException("El asiento numero "+nroAsiento+" no está disponible.\n");
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
    public void addCiudadesAsociadas(String ciudad){
        ciudadesAsociadas.add(ciudad);
    }

    public ArrayList<String> getCiudadesAsociadas() {
        return ciudadesAsociadas;
    }
}