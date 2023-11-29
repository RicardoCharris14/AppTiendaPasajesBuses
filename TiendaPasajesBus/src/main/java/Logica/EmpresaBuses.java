package Logica;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class EmpresaBuses {
    private static EmpresaBuses instancia;
    private int nroBuses;
    private int capacidadBuses;
    private ArrayList<Bus> buses;
    private ArrayList<Bus> busesSolicitados;
    private ArrayList<String> ciudadesAsociadas;
    private ArrayList<LocalDate> fechasViajes;
    private EmpresaBuses(int capacidadBuses){
        busesSolicitados = new ArrayList<>();
        ciudadesAsociadas = new ArrayList<>();
        fechasViajes = new ArrayList<>();
        nroBuses = 0;
        this.capacidadBuses = capacidadBuses;

        buses = new ArrayList<>();
    }
    public void agregarBus(Bus bus, String origen, String destino, LocalDateTime fecha, int precio){
        Boolean fechaExiste = false;
        int contadorBusesIgualDia = 0;
        if(bus!=null && buses.size()<capacidadBuses){
            if(ciudadesAsociadas.contains(origen) && ciudadesAsociadas.contains(destino)){
                for(Bus bus1 : buses){
                    if(bus1.getRecorrido().getOrigen().equals(origen) &&
                            bus1.getRecorrido().getDestino().equals(destino) &&
                            bus1.getRecorrido().getFechaSalida().toLocalDate().toString().equals(fecha.toLocalDate().toString())){
                        contadorBusesIgualDia +=1;
                    }
                }
                if(contadorBusesIgualDia<4){
                    nroBuses+=1;
                    LocalDate fechaSinHora = fecha.toLocalDate();
                    Recorrido recorrido= new Recorrido(origen,destino,fecha);
                    bus.setRecorrido(recorrido);
                    bus.setValorPasaje(precio);
                    buses.add(bus);
                    for(LocalDate fechaNoHora : fechasViajes){
                        if(fechaNoHora.toString().equals(fechaSinHora.toString())){
                            fechaExiste=true;
                            break;
                        }
                    }
                    if(!fechaExiste){
                        fechasViajes.add(fechaSinHora);
                    }
                }else{
                    System.out.println("\nNo pueden haber mas buses desde "+origen+" hacia "+destino+" en la fecha indicada.");
                }
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
    public void filtrarBuses(String origen, String destino, String fecha) {
        busesSolicitados.clear();

        for(Bus bus : buses){
            if(bus.getRecorrido().getOrigen().equals(origen) &&
                    bus.getRecorrido().getDestino().equals(destino) &&
                    bus.getRecorrido().getFechaSalida().toLocalDate().toString().equals(fecha)){
                busesSolicitados.add(bus);
            }
        }
    }
    public ArrayList<Bus> getBusesSolicitados(){
        return busesSolicitados;
    }
    public void addCiudadesAsociadas(String ciudad){
        ciudadesAsociadas.add(ciudad);
    }

    public ArrayList<String> getCiudadesAsociadas() {
        return ciudadesAsociadas;
    }
    public ArrayList<LocalDate> getFechasViajes(){
        return fechasViajes;
    }

    public static EmpresaBuses getEmpresaBuses(int capacidadBuses) {
        if (instancia == null) {
            instancia = new EmpresaBuses(capacidadBuses);
        }
        return instancia;
    }
}