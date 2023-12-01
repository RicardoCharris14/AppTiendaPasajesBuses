package Grafica;

import Logica.EmpresaBuses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelPrincipal extends JPanel {
    private CardLayout cardLayout;
    private PanelPrincipal esteObjeto = this;
    private PanelEleccionTrayecto panel1;
    private PanelViajesDisponibles panel2;
    private PanelEleccionAsiento panel3;
    public PanelPrincipal(){
        panel1 = new PanelEleccionTrayecto();
        panel2 = new PanelViajesDisponibles();
        panel3 = new PanelEleccionAsiento();

        cardLayout = new CardLayout();
        this.setLayout(cardLayout);

        this.add(panel1,"panel1");
        this.add(panel2,"panel2");
        this.add(panel3,"panel3");

        cardLayout.show(this,"panel1");

        accionBtnBuscarPasaje();
        accionBtnVolverPanel2();
        accionBtnVolverPanel3();
    }
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
                        int numBusesSolicitados = EmpresaBuses.getEmpresaBuses(0).getBusesSolicitados().size();
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
    private void accionBtnVolverPanel2(){
        ActionListener accion2 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                cardLayout.show(esteObjeto,"panel1");
            }
        };
        panel2.accionBtnVolver(accion2);
    }
    private ActionListener accionBtnsComprarPanel2(int busSolicitado){
        ActionListener accion3 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                EmpresaBuses.getEmpresaBuses(0).elejirBus(busSolicitado);
                System.out.println(EmpresaBuses.getEmpresaBuses(0).getBusSolicitado().getRecorrido().getDatosRecorrido());
                panel3.eliminarBtnsPiso();
                panel3.mostrarPiso1();
                panel3.setCantidadPisos(EmpresaBuses.getEmpresaBuses(0).getBusSolicitado().getPisos().getNroPisos());
                accionBtnPiso1Panel3();
                accionBtnPiso2Panel3();
                cardLayout.show(esteObjeto,"panel3");
            }
        };
        return accion3;
    }
    private void accionBtnVolverPanel3(){
        ActionListener accion4 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                cardLayout.show(esteObjeto,"panel2");
            }
        };
        panel3.accionBtnVolver(accion4);
    }
    private void accionBtnPiso1Panel3(){
        ActionListener accion5 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel3.mostrarPiso1();
            }
        };
        panel3.crearBtnPiso1(accion5);
    }
    private void accionBtnPiso2Panel3(){
        ActionListener accion6 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel3.mostrarPiso2();
            }
        };
        panel3.crearBtnPiso2(accion6);
    }
}