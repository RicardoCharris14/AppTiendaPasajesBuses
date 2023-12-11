package Grafica;

import Logica.Bus;
import Logica.EmpresaBuses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * panel que muestra los diferentes buses con sus respectivos itinerarios
 * @author Vicente Ramirez
 * @author Ricardo Charris
 */
public class PanelViajesDisponibles extends JPanel {
    private int numeroViajes;
    JButton volver;
    JLabel instruccion;

    /**
     * inicializa las variables del panel, tales como el titulo, la etiqueta de instruccion y el boton de volver
     */
    public PanelViajesDisponibles(){
        numeroViajes = 0;

        JLabel titulo = new JLabel("VIAJES DISPONIBLES");
        Font fontTitulo = new Font("Arial", Font.ITALIC,50);
        titulo.setFont(fontTitulo);
        titulo.setForeground(Color.BLUE);
        titulo.setBackground(Color.CYAN);
        titulo.setOpaque(true);
        titulo.setBounds(430,30,540,50);

        instruccion = new JLabel("Escoja uno de los buses disponibles:");
        Font fontInstruccion = new Font("Arial", Font.BOLD, 20);
        instruccion.setFont(fontInstruccion);
        instruccion.setBounds(90,120,600,35);



        volver = new JButton("VOLVER");
        volver.setFocusPainted(false);
        volver.setBounds(30,20,100,50);

        this.add(titulo);
        this.add(instruccion);
        this.add(volver);

        this.setBackground(Color.WHITE);
        this.setLayout(null);
    }

    /**
     * le asigna un ActionListener al boton de volver
     * @param accion es el ActionListener a asignar
     */
    public void accionBtnVolver(ActionListener accion){
        volver.addActionListener(accion);
    }

    /**
     * crea los recuadros segun la cantidad de buses que coincidian con lo solicitado, si son 0 buses pide seleccionar
     * otro itinerario
     * @param g  the <code>Graphics</code> context in which to paint
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        for(int i = 0; i<EmpresaBuses.getEmpresaBuses(0).getBusesItinerarioCliente().size() ; i++){
            g.drawRect(90 ,160+130*i,1240,100);
        }
        if(EmpresaBuses.getEmpresaBuses(0).getBusesItinerarioCliente().isEmpty()){
            Font fuente = new Font("Arial",Font.ITALIC,50);
            g.setColor(Color.RED);
            g.setFont(fuente);
            g.drawString("No hay buses disponibles escoga otro itinerario",180,330);
            instruccion.setVisible(false);
        }

    }

    /**
     * imprime en pantalla la informacion de los buses y crea los botones para comprar esos buses, respectivamente
     * @param accion MouseListener que se le agregara a los botones creados
     */
    public void crearProgramacionBus(ActionListener accion){
        instruccion.setVisible(true);
        JButton botonComprarBus = new JButton("Comprar");
        botonComprarBus.setBounds(1180,160+130*numeroViajes,150,100);
        botonComprarBus.setFocusPainted(false);
        botonComprarBus.addActionListener(accion);
        this.add(botonComprarBus);

        JLabel programacionBus = getJLabel(numeroViajes);
        programacionBus.setBounds(120,160+130*numeroViajes,1050,100);
        this.add(programacionBus);

        this.numeroViajes +=1;
    }

    /**
     * elimina la informacion de los buses y el boton para comprarlos del panel
     */
    public void eliminarProgramacionBus(){
        for(int i=0;i<this.numeroViajes*2;i++){
            this.remove(3);
        }
        numeroViajes = 0;
    }

    /**
     * crea una etiqueta con la informacion del bus solicitado
     * @param i variable que indica cual sera el bus del cual crear una etiqueta
     * @return retorna la etiqueta creada
     */
    private JLabel getJLabel(int i) {
        Bus busDisponible = EmpresaBuses.getEmpresaBuses(0).getBusesItinerarioCliente().get(i);
        String programacion = "Tipo Bus: "+busDisponible.getTipoBus()+"  |  Horario salida: "
                +busDisponible.getRecorrido().getFechaSalida().toLocalTime().toString()+"  | Nro. Pisos: "+
                busDisponible.getPisos().getNroPisos()+"  |  Precio: "+busDisponible.getValorPasaje();
        JLabel programacionBus = new JLabel(programacion);
        Font fontProgramacionBus = new Font("Arial", Font.BOLD, 20);
        programacionBus.setFont(fontProgramacionBus);
        return programacionBus;
    }
}