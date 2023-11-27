package Grafica;

import javax.swing.*;
import java.awt.*;

public class PanelEleccionAsiento extends JPanel {

public PanelEleccionAsiento(){

    PanelAsientosBus fotoAsientosBus = new PanelAsientosBus();

    add(fotoAsientosBus);

    this.setBackground(Color.yellow);
    this.setLayout(null);
    this.setBounds(205, 85, 1500, 850);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

    }
}
