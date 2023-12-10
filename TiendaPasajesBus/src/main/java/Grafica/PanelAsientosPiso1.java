package Grafica;

import Logica.Asiento;
import Logica.EmpresaBuses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class PanelAsientosPiso1 extends JPanel {
    private ArrayList<Asiento> sillasSeleccionadas;
    private int numeroSillasPiso1;
    private int sillasPorColumna;
    public PanelAsientosPiso1() {
        sillasSeleccionadas = new ArrayList<>();

        this.setLayout(null);
        this.setBackground(Color.white);
    }
    private void accionSeleccionarSillas(int i,int desplazamientoX, int desplazamientoY){
        MouseListener listener1 = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {
                int clickX = e.getX();
                int clickY = e.getY();
                if(clickX >= 50 + desplazamientoX && clickX < 84 +desplazamientoX &&
                        clickY >= 30 + desplazamientoY && clickY <= 90 + desplazamientoY){

                    Asiento asiento = EmpresaBuses.getEmpresaBuses(0).getBusSolicitado()
                            .getAsiento(i);
                    if(!sillasSeleccionadas.contains(asiento) && asiento.getDisponible()){
                        System.out.println("hola");
                        sillasSeleccionadas.add(asiento);
                        repaint();
                    }
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        };
        this.addMouseListener(listener1);
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

        int numeroCiclo = 0;
        for (int i = 0; i<numeroSillasPiso1;i++){
            if(!EmpresaBuses.getEmpresaBuses(0).getBusSolicitado().getPisos().getAsiento(i+1).getDisponible()){
                g.setColor(Color.RED);

            } else if (sillasSeleccionadas.contains(EmpresaBuses.getEmpresaBuses(0)
                    .getBusSolicitado().getPisos().getAsiento(i+1))) {
                g.setColor(Color.GRAY);
            }else{
                g.setColor(Color.GREEN);
            }
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

    public void crearSeleccionadoresAsientos(){
        numeroSillasPiso1 = EmpresaBuses.getEmpresaBuses(0).getBusSolicitado().getPisos().getNroAsientosPiso1();

        if(numeroSillasPiso1 % 3 == 0){
            sillasPorColumna = numeroSillasPiso1/3;
        }else{
            sillasPorColumna = numeroSillasPiso1/3 + 1;
        }

        int desplazamientoX = 0;
        int desplazamientoY = 0;
        int nCiclos = 0;
        for(int i=0;i<numeroSillasPiso1;i++){

            accionSeleccionarSillas(i+1,desplazamientoX,desplazamientoY);
            desplazamientoY += 80;
            if((i+1)%sillasPorColumna == 0){
                nCiclos+=1;
                desplazamientoX += 60;
                desplazamientoY = 0;
                if(nCiclos == 2){
                    desplazamientoX += 60;
                }
            }
        }
    }
    public void eliminarListeners(){
        MouseListener[] mouseListeners = this.getMouseListeners();
        for(MouseListener listener : mouseListeners){
            this.removeMouseListener(listener);
        }
    }
    public void eliminarAsientosSeleccionados() {
        while(!sillasSeleccionadas.isEmpty()){
            sillasSeleccionadas.remove(0);
        }
    }
    private void movePolygon(Polygon polygon, int xDesplazamiento, int YDesplazamiento) {
        // Obtener el número de vértices del polígono
        int numVertices = polygon.npoints;

        // Mover cada vértice a la nueva posición
        for (int i = 0; i < numVertices; i++) {
            polygon.xpoints[i] += xDesplazamiento;
            polygon.ypoints[i] += YDesplazamiento;
        }
    }
}