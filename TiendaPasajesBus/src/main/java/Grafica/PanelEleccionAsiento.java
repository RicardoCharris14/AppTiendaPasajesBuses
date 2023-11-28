package Grafica;

import javax.swing.*;
import java.awt.*;

public class PanelEleccionAsiento extends JPanel {

    public PanelEleccionAsiento(){

        PanelAsientosBus fotoAsientosBus = new PanelAsientosBus();

        add(fotoAsientosBus);

        this.setBackground(Color.yellow);
        this.setLayout(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

    }
}