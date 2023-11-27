package Grafica;

import Logica.EmpresaBuses;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    public PanelPrincipal(){
        EmpresaBuses EME = new EmpresaBuses(5);
        EME.addCiudadesAsociadas("Quellón");
        EME.addCiudadesAsociadas("Villarica");
        EME.addCiudadesAsociadas("Puerto Montt");
        EME.addCiudadesAsociadas("Concepción");
        EME.addCiudadesAsociadas("Santiago");

        PanelEleccionTrayecto panel1 = new PanelEleccionTrayecto(EME);
        PanelViajesDisponibles panel2 = new PanelViajesDisponibles();
        PanelEleccionAsiento panel3 = new PanelEleccionAsiento();

        this.add(panel1);
        //this.add(panel2);
        //this.add(panel3);

        this.setLayout(new CardLayout());
    }
}
