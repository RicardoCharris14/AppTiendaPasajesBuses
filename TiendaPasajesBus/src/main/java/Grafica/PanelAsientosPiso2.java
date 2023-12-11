package Grafica;

import Logica.Asiento;
import Logica.EmpresaBuses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Clase que extiende de un JPanel, el cual representa los asientos del segundo piso del bus, los que estan
 * seleccionados y los disponibles
 * @author Vicente Ramirez
 * @author Ricardo Charris
 */
public class PanelAsientosPiso2 extends JPanel {
    private ArrayList<Asiento> sillasSeleccionadas;
    /**
     *  Instancia un arraylist donde se iran guardando las sillas seleccionadas por el usuario e inicializa
     * el panel de los asientos de piso2
     */
    public PanelAsientosPiso2(){
        sillasSeleccionadas = new ArrayList<>();

        this.setLayout(null);
        this.setBackground(Color.white);
    }
    public ArrayList<Asiento> getSillasElejidas(){
        return sillasSeleccionadas;
    }
    /**
     * Metodo que dibuja el modelo de silla del bus con sus dimensiones, y repite el proceso hasta mostrar todos
     * los asientos requeridos del segundo piso
     * @param g  the <code>Graphics</code> context in which to paint
     */
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
        int sillasPorColumna;
        int desplazamientoX=0;
        int desplazamientoY=0;
        int numeroSillasPiso1 = EmpresaBuses.getEmpresaBuses(0).getBusSolicitado().getPisos().
                getNroAsientosPiso1();
        int numeroSillasPiso2 = EmpresaBuses.getEmpresaBuses(0).getBusSolicitado().getPisos().
                getNroAsientosPiso2();
        if(numeroSillasPiso2%3==0){
            sillasPorColumna = numeroSillasPiso2/3;
        }
        else{
            sillasPorColumna = numeroSillasPiso2/3 +1;
        }

        for (int i = 0; i<numeroSillasPiso2;i++){
            String numeroSilla=""+EmpresaBuses.getEmpresaBuses(0).getBusSolicitado().
                    getPisos().getAsiento(numeroSillasPiso1+i+1).getNumAsiento();
            if(!EmpresaBuses.getEmpresaBuses(0).getBusSolicitado().getPisos().
                    getAsiento(numeroSillasPiso1+i+1).getDisponible()){
                g.setColor(Color.RED);

            } else if (sillasSeleccionadas.contains(EmpresaBuses.getEmpresaBuses(0)
                    .getBusSolicitado().getPisos().getAsiento(numeroSillasPiso1+i+1))){
                g.setColor(Color.GRAY);
            } else{
                g.setColor(Color.GREEN);
            }
            g.drawString(numeroSilla,62+desplazamientoX,45+desplazamientoY);
            g.drawPolygon(silla);
            movePolygon(silla,0,80);
            desplazamientoY+=80;
            if ((i+1)%sillasPorColumna == 0){
                numeroCiclo +=1;
                if(numeroCiclo ==2){
                    movePolygon(silla,60,0);
                    desplazamientoX+=60;
                }
                movePolygon(silla,60,-80 * sillasPorColumna);
                desplazamientoX+=60;
                desplazamientoY=0;
            }
        }
    }
    /**
     * Metodo que permite seleccionar asientos del piso 2
     * @param listener recibe un click del mouse y selecciona los asientos
     */
    public void listenerAsientos(MouseListener listener){
        this.addMouseListener(listener);
    }
    /**
     * Metodo que elimina los listeners cuando cambio de panel, para que no queden con acciones anteriores
     */
    public void eliminarAcciones(){
        MouseListener[] mouseListeners = this.getMouseListeners();
        for(MouseListener listener : mouseListeners){
            this.removeMouseListener(listener);
        }
    }
    /**
     *  Elimina todos los asientos seleccionados cuando presiono el boton de volver, para que asi pueda seleccionarlos
     *  nuevamente
     */
    public void eliminarAsientosSeleccionados() {
        while(!sillasSeleccionadas.isEmpty()){
            sillasSeleccionadas.remove(0);
        }
    }
    /**
     * Recibe un dato de tipo Polygon y lo desplaza en torno al eje x y al eje y
     * @param polygon Polygon a ser desplazado
     * @param xOffset magnitud que se desplazara el polygon en el eje x
     * @param yOffset magnitud que se desplazara el polygon en el eje y
     */
    private void movePolygon(Polygon polygon, int xOffset, int yOffset) {
        // Obtener el número de vértices del polígono
        int numVertices = polygon.npoints;

        // Mover cada vértice a la nueva posición
        for (int i = 0; i < numVertices; i++) {
            polygon.xpoints[i] += xOffset;
            polygon.ypoints[i] += yOffset;
        }
    }
}