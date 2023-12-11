package Grafica;

import Logica.Asiento;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Clase que extiende de un JPanel, el cual representa la ventana donde estan:
 * 1.- Los asientos del bus, donde se elije si es piso1 o piso2, y puede seleccionar mas de un asiento para reservarlo
 * 2.- Los botones para elejir piso1 o piso2
 * 3.- Los asientos disponibles, los ocupados y el seleccionado por el cliente
 * 4.- Esta el boton de pagar, el cual simula la compra del pasaje
 * 5.- EL boton volver, que elimina todos los cambios al cambiar de panel, para que asi se puede seleccionar
 * todo desde el principio
 * @author Vicente Ramirez
 * @author Ricardo Charris
 */
public class PanelEleccionAsiento extends JPanel {
    private PanelAsientos asientos;
    private JButton volver;
    private JButton piso1;
    private JButton piso2;
    private JButton pagar;
    private JLabel etiquetaPiso1;
    private JLabel etiquetaPiso2;
    private int cantidadPisos;
    private int precioTotal;
    private int nroSillas;
    /**
     * Metodo constructor que iniciliza todos los componentes del panel, los JLabel, los paneles interiores
     * y los botones
     */
    public PanelEleccionAsiento(){
        precioTotal = 0;
        cantidadPisos=1;
        nroSillas = 0;
        asientos = new PanelAsientos();

        volver = new JButton("Volver");
        volver.setBounds(30,20,100,50);
        volver.setFocusPainted(false);

        JLabel disponible = new JLabel("Disponible");
        Font fontDisponible = new Font("Arial", Font.ITALIC,26);
        disponible.setFont(fontDisponible);
        disponible.setForeground(Color.black);
        disponible.setBounds(590    ,280,140,50);

        JLabel ocupado = new JLabel("Ocupado");
        Font fontDisponible1 = new Font("Arial", Font.ITALIC,26);
        ocupado.setFont(fontDisponible1);
        ocupado.setForeground(Color.black);
        ocupado.setBounds(850,280,140,50);

        JLabel seleccionado = new JLabel("Asiento Seleccionado");
        Font fontDisponible2 = new Font("Arial", Font.ITALIC,26);
        seleccionado.setFont(fontDisponible2);
        seleccionado.setForeground(Color.black);
        seleccionado.setBounds(1035 ,280,300,50);

        etiquetaPiso1 = new JLabel("Piso 1");
        Font fontPiso = new Font("Arial Black",Font.BOLD,20);
        etiquetaPiso1.setFont(fontPiso);
        etiquetaPiso1.setForeground(Color.blue);
        etiquetaPiso1.setBounds(270,85,100,20);

        etiquetaPiso2 = new JLabel("Piso 2");
        etiquetaPiso2.setFont(fontPiso);
        etiquetaPiso2.setForeground(Color.blue);
        etiquetaPiso2.setBounds(270,85,100,20);
        this.setVisible(false);

        pagar = new JButton("Pagar");
        Font fontPagar = new Font("Arial Black", Font.BOLD, 35);
        pagar.setFont(fontPagar);
        pagar.setForeground(Color.blue);
        pagar.setBorder(new BevelBorder(BevelBorder.RAISED));
        pagar.setBounds(560 ,520,300,85);
        pagar.setFocusPainted(false);

        this.add(asientos);
        this.add(volver);
        this.add(disponible);
        this.add(ocupado);
        this.add(seleccionado);
        this.add(pagar);
        this.add(etiquetaPiso1);
        this.add(etiquetaPiso2);

        this.setLayout(null);
        this.setBackground(Color.yellow);
    }
    public ArrayList<Asiento> getSillasSeleccionadasP1(){
        return asientos.getSillasSeleccionadasP1();
    }
    public ArrayList<Asiento> getSillasSeleccionadasP2(){
        return asientos.getSillasSeleccionadasP2();
    }
    /**
     * Aumenta el valor del precio total
     * @param valor recibe el valor del asiento seleccionado
     */
    public void aumentarPrecioTotal(int valor){
        precioTotal+=valor;
    }
    public void setPrecioTotal(int valor){
        precioTotal = valor;
    }

    /**
     * aumenta el numero de sillas seleccionadas
     * @param nro define cuantas sillas se van a aumentar
     */
    public void aumentarNroSillas(int nro){
        nroSillas+=nro;
    }
    public void setNroSillas(int nroSillas){
        this.nroSillas = nroSillas;
    }
    /**
     * Pinta las componentes, la simbologia de los colores de las sillas del bus, los textos de precio total y numero
     * de sillas
     * @param g  the <code>Graphics</code> context in which to paint
     */
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

        g.setFont(new Font("Arial",Font.BOLD,40));
        g.drawString("Precio total: $"+precioTotal,950,450);
        g.drawString("Nro. Sillas: "+ nroSillas,950,550);

    }
    public void setCantidadPisos(int cantidadPisos){
        this.cantidadPisos = cantidadPisos;
    }
    /**
     * añade el MouseListener al boton volver
     * @param accion recibe un click del mouse y ejecuta la accion de volver
     */
    public void accionBtnVolver(ActionListener accion){
        volver.addActionListener(accion);
    }
    /**
     * Boton que  simula la compra del pasaje
     * @param accion recibe un click del mouse y ejecuta la accion de pagar
     */
    public void accionBtnComprar(ActionListener accion){
        pagar.addActionListener(accion);
    }
    /**
     * Crea el boton para elejir el piso1 del bus
     * @param accion recibe un click de mouse y selecciona el piso 1 del bus
     */
    public void crearBtnPiso1(ActionListener accion){
        if(cantidadPisos==2){
            piso1 = new JButton("Piso 1");
            Font fontPiso1 = new Font("Arial", Font.BOLD, 30);
            piso1.setFont(fontPiso1);
            piso1.setBorder(new BevelBorder(BevelBorder.RAISED));
            piso1.setBounds(535,380,150,75);
            piso1.setFocusPainted(false);
            piso1.addActionListener(accion);
            this.add(piso1);
        }
    }
    /**
     * Crea el boton paras elejir el piso 2 del bus
     * @param accion recibe un click de mouse y selecciona el piso 2 del bus
     */
    public void crearBtnPiso2(ActionListener accion){
        if(cantidadPisos==2){
            piso2 = new JButton("Piso 2");
            Font fontPiso2 = new Font("Arial", Font.BOLD, 30);
            piso2.setFont(fontPiso2);
            piso2.setBorder(new BevelBorder(BevelBorder.RAISED));
            piso2.setBounds(735,380,150,75);
            piso2.setFocusPainted(false);
            piso2.addActionListener(accion);
            this.add(piso2);
        }
    }
    /**
     * propaga el MouseListener hacia el panel asientos piso 1
     * @param listener recibe un click de mouse y selecciona asiento de piso 1
     */
    public void seleccionadoresAsientosP1(MouseListener listener){
        asientos.seleccionadoresAsientosP1(listener);
    }
    /**
     * propaga el MouseListener hacia el panel asientos piso 2
     * @param listener recibe un click de mouse y selecciona asiento de piso 2
     */
    public void seleccionadoresAsientosP2(MouseListener listener){
        asientos.seleccionadoresAsientosP2(listener);
    }

    /**
     * llama la metodo eliminarListener del panel asientos
     */
    public void eliminarListeners(){
        asientos.eliminarListeners();
    }
    /**
     * Metodo que elimina los asientos, para que puedan ser elejidos de nuevo y no presenten problemas
     */
    public void eliminarAsientosSeleccionados(){
        asientos.eliminarAsientosSeleccionados();
    }

    /**
     * elimina los botones piso 1 y piso 2
     */
    public void eliminarBtnsPiso(){
        int nroComponentes = this.getComponentCount();
        for(int i=0;i<nroComponentes-8;i++){
            this.remove(8);
        }
    }

    /**
     * muestra el panel que  contiene los asientos del piso 1
     */
    public void mostrarPiso1(){
        asientos.mostrarPiso1();
        etiquetaPiso1.setVisible(true);
        etiquetaPiso2.setVisible(false);
    }

    /**
     * muestra el panel que contiene los asientos del piso 2
     */
    public void mostrarPiso2(){
        if(cantidadPisos==2){
            asientos.mostrarPiso2();
            etiquetaPiso2.setVisible(true);
            etiquetaPiso1.setVisible(false);
        }
    }
}