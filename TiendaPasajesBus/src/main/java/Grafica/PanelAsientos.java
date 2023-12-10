package Grafica;

import Logica.Asiento;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;

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
    public ArrayList<Asiento> getSillasSeleccionadasP1(){
        return piso1.getSillasElejidas();
    }
    public ArrayList<Asiento> getSillasSeleccionadasP2(){
        return piso2.getSillasElejidas();
    }
    public void mostrarPiso1(){
        cardLayout.show(this,"piso1");
    }
    public void mostrarPiso2(){
        cardLayout.show(this,"piso2");
    }
    public void seleccionadoresAsientosP1(MouseListener listener){
        piso1.listenerAsientos(listener);
    }
    public void seleccionadoresAsientosP2(MouseListener listener){
        piso2.listenerAsientos(listener);
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