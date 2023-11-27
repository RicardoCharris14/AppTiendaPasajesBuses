package Grafica;

import Logica.EmpresaBuses;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    public PanelPrincipal(EmpresaBuses empresaBuses){

        PanelEleccionTrayecto panel1 = new PanelEleccionTrayecto(empresaBuses);
        PanelViajesDisponibles panel2 = new PanelViajesDisponibles();
        PanelEleccionAsiento panel3 = new PanelEleccionAsiento();

        this.add(panel1);
        //this.add(panel2);
        //this.add(panel3);

        this.setLayout(new CardLayout());
    }
}