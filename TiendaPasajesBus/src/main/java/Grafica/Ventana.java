package Grafica;

import Logica.EmpresaBuses;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    public Ventana(EmpresaBuses empresaBuses) {
        PanelPrincipal panel = new PanelPrincipal(empresaBuses);
        panel.setBounds(50, 50, 1435, 700);

        this.add(panel);

        this.setLayout(null);
        this.setVisible(true);
        this.setTitle("Pasaje de buses");
        this.setSize(1200,800);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.blue);
    }
}