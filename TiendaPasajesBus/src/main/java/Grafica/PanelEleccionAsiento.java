package Grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelEleccionAsiento extends JPanel {
    private CardLayout cardLayout;
    private PanelAsientos asientos;
    private JButton volver;
    private JButton piso1;
    private JButton piso2;
    private int cantidadPisos;
    public PanelEleccionAsiento(){
        cantidadPisos=1;
        asientos = new PanelAsientos();

        volver = new JButton("Volver");
        volver.setBounds(30,20,100,50);
        volver.setFocusPainted(false);

        this.add(asientos);
        this.add(volver);

        this.setLayout(null);
        this.setBackground(Color.yellow);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
    public void setCantidadPisos(int cantidadPisos){
        this.cantidadPisos = cantidadPisos;
    }
    public void accionBtnVolver(ActionListener accion){
        volver.addActionListener(accion);
    }
    public void crearBtnPiso1(ActionListener accion){
        if(cantidadPisos==2){
            piso1 = new JButton("Piso 1");
            piso1.setBounds(600,300,100,50);
            piso1.setFocusPainted(false);
            piso1.addActionListener(accion);
            this.add(piso1);
        }

    }
    public void crearBtnPiso2(ActionListener accion){
        if(cantidadPisos==2){
            piso2 = new JButton("Piso2");
            piso2.setBounds(800,300,100,50);
            piso2.setFocusPainted(false);
            piso2.addActionListener(accion);
            this.add(piso2);
        }
    }
    public void eliminarBtnsPiso(){
        int nroComponentes = this.getComponentCount();
        for(int i=0;i<nroComponentes-2;i++){
            this.remove(2);
        }
    }
    public void mostrarPiso1(){
        asientos.mostrarPiso1();
    }
    public void mostrarPiso2(){
        if(cantidadPisos==2){
            asientos.mostrarPiso2();
        }
    }
}