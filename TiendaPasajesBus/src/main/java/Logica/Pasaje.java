package Logica;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Pasaje {
    private LocalDateTime fechaSalida;
    private String origen;
    private String destino;
    private String nombreCliente;
    private String rutCliente;
    private String tipoBus;
    private ArrayList<Integer> numerosAsientos;
    private int[] pisoAsientos;
    private int valorPasaje;
    public Pasaje(Cliente cliente, Bus bus, ArrayList<Integer> numerosAsientos){
        this.numerosAsientos = numerosAsientos;

        int largo=numerosAsientos.size();
        pisoAsientos = new int[largo];

        for(int i=0;i<largo;i++){
            if(bus.getPisos().getNroAsientosPiso1()-numerosAsientos.get(i)>=0){
                pisoAsientos[i] = 1;
            }
            else{
                pisoAsientos[i] = 2;
            }
        }

        fechaSalida = bus.getRecorrido().getFechaSalida();
        origen = bus.getRecorrido().getOrigen();
        destino = bus.getRecorrido().getDestino();
        valorPasaje = bus.getValorPasaje()*largo;
        nombreCliente = cliente.getNombre();
        rutCliente = cliente.getRut();
        tipoBus = bus.getTipoBus();
    }
    public String emitirPasaje(){
        StringBuilder asientos= new StringBuilder();
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy | HH:mm ");
        String fecha = fechaSalida.format(formatoFecha);

        int largoListaAsientos = numerosAsientos.size();
        for(int i=0 ; i<largoListaAsientos;i++){
            if(i%2==0 && i!=0){
                asientos.append("\n          ");
            }
            if(i!=largoListaAsientos-1){
                asientos.append("N°").append(numerosAsientos.get(i)).append(" Piso ").append(pisoAsientos[i]).append(" | ");
            }else{
                asientos.append("N°").append(numerosAsientos.get(i)).append(" Piso ").append(pisoAsientos[i]);
            }
        }
        String pasaje = "----------------------------------------------------\n" +
                        "Fecha de salida: "+fecha+"\n" +
                        "Trayecto: "+origen+" - "+destino+"\n" +
                        "Clase de bus: "+tipoBus+"\n"+
                        "Asientos: "+asientos+"\n"+
                        "----------------------------------------------------\n" +
                        "Nombre: "+nombreCliente+"\nRut: "+rutCliente+"\n" +
                        "Valor pasaje: "+valorPasaje+"$\n"+
                        "----------------------------------------------------";
        return pasaje;
    }
}
