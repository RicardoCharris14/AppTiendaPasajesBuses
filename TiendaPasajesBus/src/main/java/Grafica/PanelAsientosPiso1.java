package Grafica;

import Logica.EmpresaBuses;

import javax.swing.*;
import java.awt.*;

public class PanelAsientosPiso1 extends JPanel {
    public PanelAsientosPiso1() {
        this.setLayout(null);
        this.setBackground(Color.white);
    }
    private static void movePolygon(Polygon polygon, int xOffset, int yOffset) {
        // Obtener el número de vértices del polígono
        int numVertices = polygon.npoints;

        // Mover cada vértice a la nueva posición
        for (int i = 0; i < numVertices; i++) {
            polygon.xpoints[i] += xOffset;
            polygon.ypoints[i] += yOffset;
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int[] xPuntos = {160,160,200,200,170,170,30,30,0,0,200,200,40,40,40,0}; // Coordenadas x de los puntos
        int[] yPuntos = {140,310,310,160,160,0,0,160,160,360,360,310,310,140,310,310}; // Coordenadas y de los puntos
        int nPuntos = 16;

        int factor = 6;
        for (int i = 0; i < xPuntos.length; i++) {
            xPuntos[i] =xPuntos[i] / factor;
            yPuntos[i] = yPuntos[i] / factor;
        }

        int sumandoX= 50;
        int sumandoY= 30;

        for (int i = 0; i < xPuntos.length; i++) {
            xPuntos[i] =xPuntos[i] + sumandoX;
        }
        for (int i = 0;  i < yPuntos.length; i++){
            yPuntos[i] =yPuntos[i] + sumandoY;
        }

        g.setColor(Color.green);
        Polygon silla = new Polygon(xPuntos,yPuntos,nPuntos);
        int numeroSillas = EmpresaBuses.getEmpresaBuses(0).getBusSolicitado().getPisos().getNroAsientosPiso1();
        int sillasPorColumna;
        if(numeroSillas%3==0){
            sillasPorColumna = numeroSillas/3;
        }
        else{
            sillasPorColumna = numeroSillas/3 +1;
        }
        int numeroCiclo = 0;
        for (int i = 0; i<numeroSillas;i++){
            g.drawPolygon(silla);
            if ((i+1)%sillasPorColumna == 0){
                numeroCiclo +=1;
                if(numeroCiclo ==2){
                    movePolygon(silla,60,0);
                }
                movePolygon(silla,60,-80 * sillasPorColumna);
            }
            movePolygon(silla,0,80);
        }
    }
}