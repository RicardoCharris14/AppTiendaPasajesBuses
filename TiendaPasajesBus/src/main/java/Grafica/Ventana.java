package Grafica;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    public Ventana() {
        this.setTitle("Pasaje de buses");
        PanelViajesDisponibles panel = new PanelViajesDisponibles();
        panel.setBounds(205, 85, 1500, 850);
        //agregamos el panel principal a la ventana
        //PanelPrincipal panel = new PanelPrincipal();
        this.add(panel);

        //add(panel);

        this.setLayout(null);
        this.setVisible(true);

        this.setSize(1200,800);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


        // con  setBounds( posicion x, posicion y, ancho, largo)
        // con setLocationRelativeTo(null)  establecemos la pantalla o la ventana al centro
        this.getContentPane().setBackground(Color.blue);


    }
}
