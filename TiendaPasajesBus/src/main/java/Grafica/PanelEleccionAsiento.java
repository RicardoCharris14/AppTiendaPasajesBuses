package Grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelEleccionAsiento extends JPanel {
    private CardLayout cardLayout;
    private PanelAsientos pisos;
    private JButton volver;
    public PanelEleccionAsiento(){
        pisos = new PanelAsientos();

        volver = new JButton("Volver");
        volver.setBounds(30,20,100,50);

        this.add(pisos);
        this.add(volver);

        this.setLayout(null);
        this.setBackground(Color.yellow);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
    public void accionBtnVolver(ActionListener accion){
        volver.addActionListener(accion);
    }
}