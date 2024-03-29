package Grafica;

import Logica.Asiento;
import Logica.Cliente;
import Logica.EmpresaBuses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Panel que contiene todos los otros paneles, realiza la gestion de acciones de botones y mouse listeners, se encarga
 * de hacer los cambios entre paneles
 * @author Vicente Ramirez
 * @author Ricardo Charris
 */
public class PanelPrincipal extends JPanel {
    private CardLayout cardLayout;
    private PanelPrincipal esteObjeto = this;
    private PanelEleccionTrayecto panel1;
    private PanelViajesDisponibles panel2;
    private PanelEleccionAsiento panel3;
    private PanelDatosComprador panel4;
    public PanelPrincipal(){
        panel1 = new PanelEleccionTrayecto();
        panel2 = new PanelViajesDisponibles();
        panel3 = new PanelEleccionAsiento();
        panel4 = new PanelDatosComprador();

        cardLayout = new CardLayout();
        this.setLayout(cardLayout);

        this.add(panel1,"panel1");
        this.add(panel2,"panel2");
        this.add(panel3,"panel3");
        this.add(panel4,"panel4");

        cardLayout.show(this,"panel1");

        accionBtnBuscarPasaje();
        accionBtnVolverPanel2();
        accionBtnVolverPanel3();
    }

    /**
     * crea un ActionListener que filtra los buses segun el itinerario escogido por el usuario y los muestra en otro panel
     */
    private void accionBtnBuscarPasaje(){
        ActionListener accion1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String seleccionOrigen = (String)panel1.getOpciones().getCiudadesOrigen().getSelectedItem();
                String seleccionDestino = (String)panel1.getOpciones().getCiudadesDestino().getSelectedItem();
                String seleccionFecha = (String)panel1.getOpciones().getFechasViaje().getSelectedItem();
                if(!seleccionOrigen.equals("Seleccione origen del viaje") &&
                        !seleccionDestino.equals("Seleccione destino del viaje") &&
                        !seleccionFecha.equals("Seleccione la fecha del viaje")){
                    if(!seleccionOrigen.equals(seleccionDestino)){
                        EmpresaBuses.getEmpresaBuses(0).filtrarBuses(seleccionOrigen,seleccionDestino,seleccionFecha);
                        int numBusesSolicitados = EmpresaBuses.getEmpresaBuses(0).getBusesItinerarioCliente().size();
                        panel2.eliminarProgramacionBus();
                        for(int i=1; i<=numBusesSolicitados; i++){
                            panel2.crearProgramacionBus(accionBtnsComprarPanel2(i));
                        }
                        cardLayout.show(esteObjeto,"panel2");

                    }
                }
            }
        };
        panel1.accionBtnBuscarTrayecto(accion1);
    }

    /**
     * crea un MouseListener que cambia del panel 2 al panel 1
     */
    private void accionBtnVolverPanel2(){
        ActionListener accion2 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                cardLayout.show(esteObjeto,"panel1");
            }
        };
        panel2.accionBtnVolver(accion2);
    }

    /**
     * crea un ActionListener que escoge un bus seleccionado por el usuario y muestra un panel con los asientos del bus
     * escogido
     * @param busSolicitado numero del bus que eleje el ActionListener
     * @return ActionListener que ejecuta lo descrito anteriormente
     */
    private ActionListener accionBtnsComprarPanel2(int busSolicitado){

        ActionListener accion3 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                EmpresaBuses.getEmpresaBuses(0).elejirBus(busSolicitado);
                System.out.println(EmpresaBuses.getEmpresaBuses(0).getBusSolicitado().getRecorrido().getDatosRecorrido());

                int nCiclosP1 = 0;
                int desplazamientoXP1 = 0;
                int desplazamientoYP1 = 0;
                int sillasPorColumnaP1;
                int nCiclosP2 = 0;
                int desplazamientoXP2 = 0;
                int desplazamientoYP2 = 0;
                int sillasPorColumnaP2;
                int numeroSillasPiso1 = EmpresaBuses.getEmpresaBuses(0).getBusSolicitado().getPisos().
                        getNroAsientosPiso1();
                int numeroSillasPiso2 = EmpresaBuses.getEmpresaBuses(0).getBusSolicitado().getPisos().
                        getNroAsientosPiso2();

                if(numeroSillasPiso1 % 3 == 0){
                    sillasPorColumnaP1 = numeroSillasPiso1/3;
                }else{
                    sillasPorColumnaP1 = numeroSillasPiso1/3 + 1;
                }
                if(numeroSillasPiso2%3==0){
                    sillasPorColumnaP2 = numeroSillasPiso2/3;
                }
                else{
                    sillasPorColumnaP2 = numeroSillasPiso2/3 +1;
                }

                panel3.setCantidadPisos(EmpresaBuses.getEmpresaBuses(0).getBusSolicitado().getPisos().getNroPisos());
                panel3.eliminarBtnsPiso();
                panel3.mostrarPiso1();
                accionBtnPiso1Panel3();
                accionBtnPiso2Panel3();
                accionComprarPasaje();
                panel3.eliminarListeners();

                for(int i=0;i<numeroSillasPiso1;i++){
                    panel3.seleccionadoresAsientosP1(accionSeleccionarSillasP1(i+1,desplazamientoXP1,desplazamientoYP1));
                    desplazamientoYP1 += 80;
                    if((i+1)%sillasPorColumnaP1 == 0){
                        nCiclosP1+=1;
                        desplazamientoXP1 += 60;
                        desplazamientoYP1 = 0;
                        if(nCiclosP1 == 2){
                            desplazamientoXP1 += 60;
                        }
                    }
                }
                for(int i=0;i<numeroSillasPiso2;i++){
                    panel3.seleccionadoresAsientosP2(accionSeleccionarSillasP2(numeroSillasPiso1+1+i,
                            desplazamientoXP2,desplazamientoYP2));
                    desplazamientoYP2+=80;
                    if ((i+1)%sillasPorColumnaP2 == 0){
                        nCiclosP2 +=1;
                        desplazamientoXP2 += 60;
                        desplazamientoYP2 = 0;
                        if(nCiclosP2 ==2){
                            desplazamientoXP2 += 60;
                        }
                    }
                }
                cardLayout.show(esteObjeto,"panel3");
            }
        };
        return accion3;
    }

    /**
     * crea un ActionListener que permite volver del panel 3 al panel 2
     */
    private void accionBtnVolverPanel3(){
        ActionListener accion4 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                panel3.setPrecioTotal(0);
                panel3.setNroSillas(0);
                panel3.eliminarAsientosSeleccionados();
                cardLayout.show(esteObjeto,"panel2");
            }
        };
        panel3.accionBtnVolver(accion4);
    }

    /**
     * crea un ActionListener que muestra los asientos del piso 1 en el panel de eleccion de asientos
     */
    private void accionBtnPiso1Panel3(){
        ActionListener accion5 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel3.mostrarPiso1();
            }
        };
        panel3.crearBtnPiso1(accion5);
    }

    /**
     * crea un MouseListener que muestra los asientos del piso 2 en el panel de eleccion de asientos
     */
    private void accionBtnPiso2Panel3(){
        ActionListener accion6 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel3.mostrarPiso2();
            }
        };
        panel3.crearBtnPiso2(accion6);
    }

    /**
     * crea un MouseListener en una zona determinada por 2 parametros, este MouseListener se encarga de seleccionar
     * la silla "i" en el piso 1
     * @param i es la silla que seleccionara el MouseListener
     * @param desplazamientoX determina la zona en el eje x en la que funcionara el MouseListener
     * @param desplazamientoY determina la zona en el eje y en la que funcionara el MouseListener
     * @return retorna el MouseListener creado
     */
    private MouseListener accionSeleccionarSillasP1(int i, int desplazamientoX, int desplazamientoY){
        MouseListener listener1 = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {
                int clickX = e.getX();
                int clickY = e.getY();
                if(clickX >= 50 + desplazamientoX && clickX < 84 +desplazamientoX &&
                        clickY >= 30 + desplazamientoY && clickY <= 90 + desplazamientoY){

                    Asiento asiento = EmpresaBuses.getEmpresaBuses(0).getBusSolicitado()
                            .getAsiento(i);
                    if(!panel3.getSillasSeleccionadasP1().contains(asiento) && asiento.getDisponible()){
                        panel3.aumentarPrecioTotal(EmpresaBuses.getEmpresaBuses(0).getBusSolicitado().
                                getValorPasaje());
                        panel3.aumentarNroSillas(1);
                        panel3.getSillasSeleccionadasP1().add(asiento);
                        repaint();
                    }
                    else if(panel3.getSillasSeleccionadasP1().contains(asiento)){
                        panel3.aumentarPrecioTotal(-1*EmpresaBuses.getEmpresaBuses(0).
                                getBusSolicitado().getValorPasaje());
                        panel3.aumentarNroSillas(-1);
                        panel3.getSillasSeleccionadasP1().remove(asiento);
                        repaint();
                    }
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        };
        return listener1;
    }

    /**
     * crea un MouseListener en una zona determinada por 2 parametros, este MouseListener se encarga de seleccionar
     * la silla "i" en el piso 2
     * @param i es la silla que seleccionara el MouseListener
     * @param desplazamientoX determina la zona en el eje x en la que funcionara el MouseListener
     * @param desplazamientoY determina la zona en el eje y en la que funcionara el MouseListener
     * @return retorna el MouseListener creado
     */
    private MouseListener accionSeleccionarSillasP2(int i,int desplazamientoX, int desplazamientoY){
        MouseListener listener1 = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {
                int clickX = e.getX();
                int clickY = e.getY();
                if(clickX >= 50 + desplazamientoX && clickX < 84 +desplazamientoX &&
                        clickY >= 30 + desplazamientoY && clickY <= 90 + desplazamientoY){
                    Asiento asiento = EmpresaBuses.getEmpresaBuses(0).getBusSolicitado()
                            .getAsiento(i);
                    if(!panel3.getSillasSeleccionadasP2().contains(asiento) && asiento.getDisponible()){
                        panel3.aumentarPrecioTotal(EmpresaBuses.getEmpresaBuses(0).getBusSolicitado().
                                getValorPasaje());
                        panel3.aumentarNroSillas(1);
                        panel3.getSillasSeleccionadasP2().add(asiento);
                        repaint();
                    }else if(panel3.getSillasSeleccionadasP2().contains(asiento)){
                        panel3.aumentarPrecioTotal(-1*EmpresaBuses.getEmpresaBuses(0).
                                getBusSolicitado().getValorPasaje());
                        panel3.aumentarNroSillas(-1);
                        panel3.getSillasSeleccionadasP2().remove(asiento);
                    }
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        };
        return listener1;
    }

    /**
     * crea un ActionListener que se encarga de mostrar el panel en el cual el usuario ingresara sus datos
     */
    private void accionComprarPasaje(){
        ActionListener accionBtnComprar= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!panel3.getSillasSeleccionadasP1().isEmpty() || !panel3.getSillasSeleccionadasP2().isEmpty()){
                    accionBtnReservar();
                    cardLayout.show(esteObjeto,"panel4");
                }
            }
        };
        panel3.accionBtnComprar(accionBtnComprar);
    }

    /**
     * crea un ActionListener que se encarga de reservar el/los asientos escogidos y crea un pasaje con los datos
     * del usuario
     */
    private void accionBtnReservar(){
        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmpresaBuses empresa = EmpresaBuses.getEmpresaBuses(0);
                ArrayList<Asiento> sillasAComprarP1 = panel3.getSillasSeleccionadasP1();
                ArrayList<Asiento> sillasAComprarP2 = panel3.getSillasSeleccionadasP2();
                int cantidadAsientosPiso1 = sillasAComprarP1.size();
                int cantidadAsientosPiso2 = sillasAComprarP2.size();
                int[] asientos = new int[cantidadAsientosPiso1+cantidadAsientosPiso2];
                String nombre = panel4.getNombreUsuario().getText();
                String rut = panel4.getRutUsuario().getText();

                if(!nombre.isEmpty() && !rut.isEmpty()){
                    Cliente cliente = new Cliente(nombre,rut);
                    for(int i=0;i<cantidadAsientosPiso1;i++){
                        asientos[i]=sillasAComprarP1.get(i).getNumAsiento();
                    }
                    for(int i=0;i<cantidadAsientosPiso2;i++){
                        asientos[cantidadAsientosPiso1+i]=sillasAComprarP2.get(i).getNumAsiento();
                    }

                    cliente.comprarPasaje(empresa, empresa.getBusSolicitado(), asientos);

                    panel4.getNombreUsuario().setText("");
                    panel4.getRutUsuario().setText("");
                    panel3.setPrecioTotal(0);
                    panel3.setNroSillas(0);
                    panel3.eliminarAsientosSeleccionados();
                    cardLayout.show(esteObjeto,"panel1");

                    String pasaje = cliente.getPasaje().emitirPasaje();
                    JOptionPane.showMessageDialog(null,pasaje,"PASAJE", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        };
        panel4.addActionBtnReserva(accion);
    }
}