package Grafica;

import javax.swing.*;
import java.awt.*;

public class PanelViajesDisponibles extends JPanel {
    public PanelViajesDisponibles(){

        JLabel titulo = new JLabel("VIAJES DISPONIBLES");
        Font fontTitulo = new Font("Arial", Font.ITALIC,50);
        titulo.setFont(fontTitulo);
        titulo.setForeground(Color.BLUE);
        titulo.setBackground(Color.CYAN);
        titulo.setOpaque(true);
        titulo.setBounds(500,30,525,50);

        JLabel instruccion = new JLabel("Escoja uno de los buses disponibles:");
        Font fontInstruccion = new Font("Arial", Font.BOLD, 20);
        instruccion.setFont(fontInstruccion);
        instruccion.setBounds(150,120,600,20);

        JButton volver = new JButton("VOLVER");
        volver.setFocusPainted(false);
        volver.setBounds(30,20,100,50);

        this.add(titulo);
        this.add(instruccion);
        this.add(volver);

        this.setBackground(Color.WHITE);
        this.setLayout(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        for(int i=0 ; i<5 ; i++){
            g.drawRect(150 ,160+130*i,1200,100);
            JButton botonBus = new JButton("Comprar");
            botonBus.setBounds(1200,160+130*i,150,100);
            botonBus.setFocusPainted(false);
            this.add(botonBus);
        }

    }
}