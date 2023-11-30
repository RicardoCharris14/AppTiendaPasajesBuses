package Grafica;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PanelAsientos extends JPanel {
    CardLayout cardLayout;
    private PanelAsientosPiso1 piso1;
    private PanelAsientosPiso2 piso2;
    public PanelAsientos(){
        cardLayout = new CardLayout();
        this.setLayout(cardLayout);

        piso1 = new PanelAsientosPiso1();
        piso2 = new PanelAsientosPiso2();

        this.add(piso1,"piso1");
        this.add(piso2,"piso2");

        this.setBounds(70,110,320,530);
        this.setBackground(Color.white);
        LineBorder borde = new LineBorder(Color.BLACK, 2, true);
        this.setBorder(borde);
        cardLayout.show(this,"piso1");
    }

}