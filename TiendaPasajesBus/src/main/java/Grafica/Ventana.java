package Grafica;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    public Ventana() {
        this.setTitle("Pasaje de buses");

        //agregamos el panel principal a la ventana
        PanelPrincipal panel = new PanelPrincipal();


        add(panel);

        this.setLayout(null);
        this.setVisible(true);

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // con  setBounds( posicion x, posicion y, ancho, largo)
        // con setLocationRelativeTo(null)  establecemos la pantalla o la ventana al centro
        this.getContentPane().setBackground(Color.blue);


    }
}
