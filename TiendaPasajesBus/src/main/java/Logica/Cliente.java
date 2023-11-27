package Logica;

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
    public void comprarPasaje(EmpresaBuses empresa, int nroBus, int nroAsiento){
        try{
            pasaje = empresa.comprarPasaje(this,nroBus,nroAsiento);
        }catch (AsientoOcupadoException e){
            System.out.println("\n"+e.getMessage());
        }
    }
    public Pasaje getPasaje(){
        return pasaje;
    }
}
