package Logica;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *clase que representa una empresa de buses. Esta empresa puede contener buses con distintos trayectos en diferentes
 * fechas y permite a los usuarios comprar pasajes para sus buses
 * @author Vicente Ramirez
 * @author Ricardo Charris
 */
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

    /**
     *constructor privado para que no se pueda hacer new de EmpresaBuses, este metodo instancia las variables
     * @param capacidadBuses numero de buses que puede contener la Empresa
     */
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

    /**
     * si no existe una instancia de EmpresaBuses se crea un objeto de esta, en cambio, si existe una instancia retorna
     * esa instancia ya existente
     * @param capacidadBuses numero de buses que puede contener la empresa
     * @return instancia de EmpresaBuses
     */
    public static EmpresaBuses getEmpresaBuses(int capacidadBuses) {
        if (instancia == null) {
            instancia = new EmpresaBuses(capacidadBuses);
        }
        return instancia;
    }

    /**
     * se encarga de reservar uno o mas asientos de un bus en especifico, luego crea el pasaje y se lo entrega al
     * cliente
     * @param cliente usuario que compra el pasaje
     * @param busSolicitado bus del cual se escojeran los asientos
     * @param numerosAsientos array con los numeros de los asientos que se quiere comprar
     * @return devuelve un pasaje con los asientos que se compraron
     */
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

    /**
     * agrega un bus con un itinerario designado a la empresa
     * @param bus bus a agregar
     * @param origen origen del trayecto
     * @param destino destino del trayecto
     * @param fecha fecha de salida
     * @param precio precio del bus
     */
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

    /**
     * Elimina un bus de la empresa
     * @param nroBus numero de bus a eliminar
     */
    public void retirarBus(int nroBus){
        buses.remove(nroBus-1);
    }

    /**
     * guarda en una variable los buses que le sirven al cliente segun el origen, destino y fecha solicitados
     * @param origen origen del trayceto
     * @param destino destino del trayecto
     * @param fecha fecha de salida
     */
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

    /**
     * selecciona el bus del cual se compraran los asientos
     * @param eleccion numero de bus a elejir
     */
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