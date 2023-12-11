package Grafica;

import Logica.Asiento;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;


/**
 * Clase que extiende un panel, en el cual se simulan los asientos  del interior de un bus, donde el cliente
 * podra seleccionar uno o mas asientos disponibles, dependiendo del piso que prefiera
 * @author Vicente Ramirez
 * @author Ricardo Charris
 */
public class PanelAsientos extends JPanel {
    private CardLayout cardLayout;
    private PanelAsientosPiso1 piso1;
    private PanelAsientosPiso2 piso2;

    /**
     * Metodo que crea instancias de PanelAsientosPiso1 y PanelAsientosPiso2, y lo superpone en PanelAsientos
     */
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
    /**
     * muestra el panel que visualiza los asientos del primer piso
     */
    public void mostrarPiso1(){
        cardLayout.show(this,"piso1");
    }
    /**
     * muestra el panel visualiza los asientos del segundo piso
     */
    public void mostrarPiso2(){
        cardLayout.show(this,"piso2");
    }
    /**
     * Se encarga de propagar el MouseListener hacia el panel que muestra los asientos en el primer piso
     * @param listener es el MouseListener que permite seleccionar los asientos
     */
    public void seleccionadoresAsientosP1(MouseListener listener){
        piso1.listenerAsientos(listener);
    }
    /**
     * Se encarga de propagar el MouseListener hacia el panel que muestra los asientos en el segundo piso
     * @param listener es el MouseListener que permite seleccionar los asientos
     */
    public void seleccionadoresAsientosP2(MouseListener listener){
        piso2.listenerAsientos(listener);
    }
    /**
     * Elimina todos los listeners cuando cambio de panel, para que no queden listeners con acciones anteriores
     */
    public void eliminarListeners(){
        piso1.eliminarListeners();
        piso2.eliminarAcciones();
    }
    /**
     * Elimina todos los asientos seleccionados del primer y segundo piso
     */
    public void eliminarAsientosSeleccionados(){
        piso1.eliminarAsientosSeleccionados();
        piso2.eliminarAsientosSeleccionados();
    }

}