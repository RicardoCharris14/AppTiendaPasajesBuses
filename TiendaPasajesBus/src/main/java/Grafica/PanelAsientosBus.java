package Grafica;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PanelAsientosBus extends JPanel {
    public PanelAsientosBus() {
        this.setBounds(100,50,400,700);
        this.setLayout(null);
        this.setBackground(Color.white);
        LineBorder borde = new LineBorder(Color.BLACK, 2, true);
        this.setBorder(borde);


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

        int factor= 4;
        for (int i = 0; i < xPuntos.length; i++) {
            xPuntos[i] =xPuntos[i] / factor;
            yPuntos[i] = yPuntos[i] / factor;
        }

        int sumando= 50;
        for (int i = 0; i < xPuntos.length; i++) {
            xPuntos[i] =xPuntos[i] + sumando;
            yPuntos[i] =yPuntos[i] + sumando;
        }

        g.setColor(Color.green);
        Polygon silla = new Polygon(xPuntos,yPuntos,nPuntos);
        int numeroSillas= 12;
        int sillasPorColumna = numeroSillas/3;
        int numeroCiclo = 0;
        for (int i = 0; i<numeroSillas;i++){
            g.drawPolygon(silla);
            if ((i+1)%sillasPorColumna == 0){
                numeroCiclo +=1;
                if(numeroCiclo ==2){
                    movePolygon(silla,60,0);
                }
                movePolygon(silla,100,-120 * sillasPorColumna);
            }
            movePolygon(silla,0,120);
        }





    }
}