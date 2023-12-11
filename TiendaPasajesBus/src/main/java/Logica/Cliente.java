package Logica;

/**
 * clase que representa al cliente que comprar en la empresa de buses, el cliente tiene un nombre y un rut
 * @author Vicente Ramirez
 * @author Ricardo Charris
 */
public class Cliente {
    private final String nombre;
    private final String rut;
    private Pasaje pasaje;
    public Cliente(String nombre, String rut){
        this.nombre = nombre;
        this.rut = rut;
    }
    public String getNombre(){
        return nombre;
    }
    public String getRut(){
        return rut;
    }

    /**
     * se encarga de comprar uno o mas pasajes en una Empresa de buses
     * @param empresa es la empresa en la cual se compraran los asientos
     * @param busSeleccionado es el bus del cual se seleccionaran los asientos
     * @param nroAsiento un arreglo de enteros con todas las sillas que quieres comprar
     */
    public void comprarPasaje(EmpresaBuses empresa, Bus busSeleccionado, int[] nroAsiento){

        pasaje = empresa.comprarPasaje(this,busSeleccionado,nroAsiento);

    }
    public Pasaje getPasaje(){
        return pasaje;
    }
}
