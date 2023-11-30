package Grafica;

import javax.swing.*;
import java.awt.*;

public class PanelEleccionAsiento extends JPanel {
    private CardLayout cardLayout;
    private PanelAsientos pisos;
    private JButton volver;
    public PanelEleccionAsiento(){
        pisos = new PanelAsientos();

        volver = new JButton("Volver");
        
        this.add(pisos);

        this.setLayout(null);
        this.setBackground(Color.yellow);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
}