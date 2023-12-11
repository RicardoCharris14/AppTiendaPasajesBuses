package Logica;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class EmpresaBuses {
    private static EmpresaBuses instancia;
    private int capacidadBuses;
    private ArrayList<String> ciudadesAsociadas;
    private ArrayList<LocalDate> fechasViajes;
    private ArrayList<Bus> buses;
    private ArrayList<Bus> busesItinerarioCliente;
    private ArrayList<Cliente> clientes;
    private Bus busSolicitado;
    private int nroBuses;
    private EmpresaBuses(int capacidadBuses){
        this.capacidadBuses = capacidadBuses;
        ciudadesAsociadas = new ArrayList<>();
        fechasViajes = new ArrayList<>();
        buses = new ArrayList<>();
        busesItinerarioCliente = new ArrayList<>();
        clientes = new ArrayList<>();
        busSolicitado=null;
        nroBuses = 0;
    }
    public static EmpresaBuses getEmpresaBuses(int capacidadBuses) {
        if (instancia == null) {
            instancia = new EmpresaBuses(capacidadBuses);
        }
        return instancia;
    }
    public Pasaje comprarPasaje(Cliente cliente, Bus busSolicitado, int[] numerosAsientos){
        if(buses.contains(busSolicitado)){
            int largoNumerosAsientos = numerosAsientos.length;
            ArrayList<Integer> asientosAComprar = new ArrayList<>();

            for(int i=0;i<largoNumerosAsientos;i++){
                Asiento asientoSolicitado = busSolicitado.getAsiento(numerosAsientos[i]);
                if(asientoSolicitado!= null){
                    if(asientoSolicitado.getDisponible()){
                        asientoSolicitado.setDisponible(false);
                        asientosAComprar.add(asientoSolicitado.getNumAsiento());
                    }
                    else{
                        System.out.println(("El asiento numero "+numerosAsientos[i]+" no estÃ¡ disponible.\n"));
                    }
                }
            }
            if(asientosAComprar.isEmpty()){
                return null;
            }else{
                clientes.add(cliente);
                Pasaje pasaje = new Pasaje(cliente, busSolicitado, asientosAComprar);
                System.out.println(pasaje.emitirPasaje());
                return pasaje;
            }

        }
        else{
            return null;
        }
    }
    public void agregarBus(Bus bus, String origen, String destino, LocalDateTime fecha, int precio){
        boolean fechaExiste = false;
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
    public void filtrarBuses(String origen, String destino, String fecha) {
        busesItinerarioCliente.clear();

        for(Bus bus : buses){
            if(bus.getRecorrido().getOrigen().equals(origen) &&
                    bus.getRecorrido().getDestino().equals(destino) &&
                    bus.getRecorrido().getFechaSalida().toLocalDate().toString().equals(fecha)){
                busesItinerarioCliente.add(bus);
            }
        }
    }
    public void elejirBus(int eleccion){
        busSolicitado = busesItinerarioCliente.get(eleccion-1);
    }
    public Bus getBusSolicitado(){
        return busSolicitado;
    }
    public ArrayList<Bus> getBusesItinerarioCliente(){
        return busesItinerarioCliente;
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
}