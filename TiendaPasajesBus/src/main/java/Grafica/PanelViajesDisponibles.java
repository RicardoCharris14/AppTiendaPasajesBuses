package Grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelViajesDisponibles extends JPanel {
    JButton volver;
    public PanelViajesDisponibles(){

        JLabel titulo = new JLabel("VIAJES DISPONIBLES");
        Font fontTitulo = new Font("Arial", Font.ITALIC,50);
        titulo.setFont(fontTitulo);
        titulo.setForeground(Color.BLUE);
        titulo.setBackground(Color.CYAN);
        titulo.setOpaque(true);
        titulo.setBounds(500,30,540,50);

        JLabel instruccion = new JLabel("Escoja uno de los buses disponibles:");
        Font fontInstruccion = new Font("Arial", Font.BOLD, 20);
        instruccion.setFont(fontInstruccion);
        instruccion.setBounds(115,120,600,20);

        volver = new JButton("VOLVER");
        volver.setFocusPainted(false);
        volver.setBounds(30,20,100,50);

        for(int i=0;i<4;i++){
            JButton botonBus = new JButton("Comprar");
            botonBus.setBounds(1200,160+130*i,150,100);
            botonBus.setFocusPainted(false);
            this.add(botonBus);
        }

        this.add(titulo);
        this.add(instruccion);
        this.add(volver);

        this.setBackground(Color.WHITE);
        this.setLayout(null);
    }
    public void accionBtnVolver(ActionListener accion){
        volver.addActionListener(accion);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        for(int i=0 ; i<4 ; i++){
            g.drawRect(115 ,160+130*i,1235,100);
        }

    }
}