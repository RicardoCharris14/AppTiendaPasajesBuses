package Grafica;

import Logica.EmpresaBuses;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    public Ventana(EmpresaBuses empresaBuses) {
        PanelPrincipal panel = new PanelPrincipal(empresaBuses);
        panel.setBounds(205, 85, 1500, 850);

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