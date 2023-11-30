package Grafica;

import Logica.Bus;
import Logica.EmpresaBuses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelViajesDisponibles extends JPanel {
    private int numeroViajes;
    JButton volver;
    public PanelViajesDisponibles(){
        numeroViajes = 0;

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
        for(int i=0 ; i<EmpresaBuses.getEmpresaBuses(0).getBusesSolicitados().size() ; i++){
            g.drawRect(115 ,160+130*i,1235,100);
        }
    }
    public void crearProgramacionBus(ActionListener accion){
        JButton botonComprarBus = new JButton("Comprar");
        botonComprarBus.setBounds(1200,160+130*numeroViajes,150,100);
        botonComprarBus.setFocusPainted(false);
        botonComprarBus.addActionListener(accion);
        this.add(botonComprarBus);

        JLabel programacionBus = getJLabel(numeroViajes);
        programacionBus.setBounds(150,160+130*numeroViajes,1050,100);
        this.add(programacionBus);

        this.numeroViajes +=1;
    }
    public void eliminarProgramacionBus(){
        for(int i=0;i<this.numeroViajes*2;i++){
            this.remove(3);
        }
        numeroViajes = 0;
    }

    private JLabel getJLabel(int i) {
        Bus busDisponible = EmpresaBuses.getEmpresaBuses(0).getBusesSolicitados().get(i);
        String programacion = "Tipo Bus: "+busDisponible.getTipoBus()+"  |  Horario salida: "
                +busDisponible.getRecorrido().getFechaSalida().toLocalTime().toString()+"  | Nro. Pisos: "+
                busDisponible.getPisos().getNroPisos()+"  |  Precio: "+busDisponible.getValorPasaje();
        JLabel programacionBus = new JLabel(programacion);
        Font fontProgramacionBus = new Font("Arial", Font.BOLD, 20);
        programacionBus.setFont(fontProgramacionBus);
        return programacionBus;
    }
}