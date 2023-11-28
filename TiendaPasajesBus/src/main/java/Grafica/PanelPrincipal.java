package Grafica;

import Logica.EmpresaBuses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelPrincipal extends JPanel {
    EmpresaBuses empresaBuses;
    private CardLayout cardLayout;
    PanelPrincipal esteObjeto = this;
    PanelEleccionTrayecto panel1;
    PanelViajesDisponibles panel2;
    PanelEleccionAsiento panel3;
    public PanelPrincipal(EmpresaBuses empresaBuses){
        this.empresaBuses = empresaBuses;

        panel1 = new PanelEleccionTrayecto(empresaBuses);
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
                        empresaBuses.filtrarBuses(seleccionOrigen,seleccionDestino,seleccionFecha);
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
}