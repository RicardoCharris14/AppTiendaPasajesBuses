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

        this.setBounds(150,110,320,530);
        this.setBackground(Color.white);
        LineBorder borde = new LineBorder(Color.BLACK, 2, true);
        this.setBorder(borde);
        cardLayout.show(this,"piso1");
    }
    public void mostrarPiso1(){
        cardLayout.show(this,"piso1");
    }
    public void mostrarPiso2(){
        cardLayout.show(this,"piso2");
    }
    public void crearSeleccionadoresAsientos(){
        piso1.crearSeleccionadoresAsientos();
        piso2.crearSeleccionadoresAsientos();
    }
    public void eliminarListeners(){
        piso1.eliminarListeners();
        piso2.eliminarAcciones();
    }
    public void eliminarAsientosSeleccionados(){
        piso1.eliminarAsientosSeleccionados();
        piso2.eliminarAsientosSeleccionados();
    }

}