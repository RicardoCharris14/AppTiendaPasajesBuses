package Grafica;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    public Ventana() {
        PanelPrincipal panel1 = new PanelPrincipal();

        PanelViajesDisponibles panel2 = new PanelViajesDisponibles();
        panel2.setBounds(205, 85, 1500, 850);

        PanelEleccionAsiento panel3 = new PanelEleccionAsiento();

        //this.add(panel1);
        //this.add(panel2);
        this.add(panel3);

        this.setLayout(null);
        this.setVisible(true);
        this.setTitle("Pasaje de buses");
        this.setSize(1200,800);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.blue);
    }
}
