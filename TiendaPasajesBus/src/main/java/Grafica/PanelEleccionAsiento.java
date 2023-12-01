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
    private JButton pagar;
    private int cantidadPisos;
    public PanelEleccionAsiento(){
        cantidadPisos=1;
        asientos = new PanelAsientos();

        volver = new JButton("Volver");
        volver.setBounds(30,20,100,50);
        volver.setFocusPainted(false);

        JLabel disponible = new JLabel("Disponible");
        Font fontDisponible = new Font("Arial", Font.ITALIC,23);
        disponible.setFont(fontDisponible);
        disponible.setForeground(Color.black);
        disponible.setBounds(600,280,140,50);

        JLabel ocupado = new JLabel("Ocupado");
        Font fontDisponible1 = new Font("Arial", Font.ITALIC,23);
        ocupado.setFont(fontDisponible1);
        ocupado.setForeground(Color.black);
        ocupado.setBounds(850,280,140,50);

        JLabel seleccionado = new JLabel("Asiento Seleccionado");
        Font fontDisponible2 = new Font("Arial", Font.ITALIC,23);
        seleccionado.setFont(fontDisponible2);
        seleccionado.setForeground(Color.black);
        seleccionado.setBounds(1035 ,280,300,50);




        this.add(asientos);
        this.add(volver);
        this.add(disponible);
        this.add(ocupado);
        this.add(seleccionado);


        this.setLayout(null);
        this.setBackground(Color.yellow);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.white);
        g.fillRect(575,40,150,220);
        g.setColor(Color.black);
        g.drawRect(575,40,150,220);

        g.setColor(Color.white);
        g.fillRect(825,40,150,220);
        g.setColor(Color.black);
        g.drawRect(825,40,150,220);

        g.setColor(Color.white);
        g.fillRect(1075,40,150,220);
        g.setColor(Color.black);
        g.drawRect(1075,40,150,220);

        int[] xPuntos = {160,160,200,200,170,170,30,30,0,0,200,200,40,40,40,0}; // Coordenadas x de los puntos
        int[] yPuntos = {140,310,310,160,160,0,0,160,160,360,360,310,310,140,310,310}; // Coordenadas y de los puntos
        int nPuntos = 16;
        int factor = 2;

        int[] xPuntos1 = {160,160,200,200,170,170,30,30,0,0,200,200,40,40,40,0}; // Coordenadas x de los puntos
        int[] yPuntos1 = {140,310,310,160,160,0,0,160,160,360,360,310,310,140,310,310}; // Coordenadas y de los puntos

        int[] xPuntos2 = {160,160,200,200,170,170,30,30,0,0,200,200,40,40,40,0}; // Coordenadas x de los puntos
        int[] yPuntos2 = {140,310,310,160,160,0,0,160,160,360,360,310,310,140,310,310}; // Coordenadas y de los puntos

        int sumandoX= 600;
        int sumandoY= 60;
        int sumandoX1 =850;
        int sumandoX2 = 1100;

        for (int i = 0; i < xPuntos.length; i++) {
            xPuntos[i] =xPuntos[i] / factor;
            yPuntos[i] = yPuntos[i] / factor;
            xPuntos1[i] = xPuntos1[i]/ factor;
            yPuntos1[i] = yPuntos1[i]/ factor;
            xPuntos2[i] = xPuntos2[i]/ factor;
            yPuntos2[i] = yPuntos2[i]/ factor;
        }


        for (int i = 0; i < xPuntos.length; i++) {
            xPuntos[i] =xPuntos[i] + sumandoX;
            xPuntos1[i] = xPuntos1[i] + sumandoX1;
            xPuntos2[i] = xPuntos2[i] + sumandoX2;

        }
        for (int i = 0;  i < yPuntos.length; i++){
            yPuntos[i] = yPuntos[i] + sumandoY;
            yPuntos1[i] = yPuntos1[i] + sumandoY;
            yPuntos2[i] = yPuntos2[i] + sumandoY;

        }

        g.setColor(Color.green);
        g.drawPolygon(xPuntos,yPuntos,nPuntos);
        g.setColor(Color.red);
        g.drawPolygon(xPuntos1,yPuntos1,nPuntos);
        g.setColor(Color.gray);
        g.drawPolygon(xPuntos2,yPuntos2,nPuntos);
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
            Font fontPiso1 = new Font("Arial", Font.BOLD, 20);
            piso1.setFont(fontPiso1);
            piso1.setBounds(735,380,150,75);
            piso1.setFocusPainted(false);
            piso1.addActionListener(accion);
            this.add(piso1);
        }

    }
    public void crearBtnPiso2(ActionListener accion){
        if(cantidadPisos==2){
            piso2 = new JButton("Piso2");
            Font fontPiso2 = new Font("Arial", Font.BOLD, 20);
            piso2.setFont(fontPiso2);
            piso2.setBounds(935,380,150,75);
            piso2.setFocusPainted(false);
            piso2.addActionListener(accion);
            this.add(piso2);
        }
    }
    
    public void eliminarBtnsPiso(){
        int nroComponentes = this.getComponentCount();
        for(int i=0;i<nroComponentes-8;i++){
            this.remove(8);
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