package Grafica;

import Logica.EmpresaBuses;

import javax.swing.*;
import java.awt.*;

/**
 * es la ventana principal donde se anaden todos los otros componentes, es la cual delimita el tamano limite que pueden
 * tomar los componentes
 * @author Vicente Ramirez
 * @author Ricardo Charris
 */
public class Ventana extends JFrame {

    public Ventana() {
        PanelPrincipal panel = new PanelPrincipal();
        panel.setBounds(30, 30, 1400, 700);

        this.add(panel);

        this.setLayout(null);
        this.setVisible(true);
        this.setTitle("Pasaje de buses");
        this.setSize(1500,800);

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.blue);
    }
}