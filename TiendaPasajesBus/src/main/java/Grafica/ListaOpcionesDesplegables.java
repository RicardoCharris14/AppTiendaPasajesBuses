package Grafica;

import javax.swing.*;
import java.awt.*;

public class ListaOpcionesDesplegables{

    private JComboBox listaCiudadesDeOrigen;
    private JComboBox listaCiudadesDeDestino;
    private JComboBox listaFechasViaje;
    private JButton buscarViajes;


    public ListaOpcionesDesplegables() {
        String [] ciudadesOrigen = {"Seleccione el origen del viaje", "Quellón", "Puerto Montt", "Villarrica", "Concepción", "Rancagua"};
        listaCiudadesDeOrigen = new JComboBox(ciudadesOrigen);
        listaCiudadesDeOrigen.setBounds(150,340,300,50);
        listaCiudadesDeOrigen.setMaximumRowCount(4);
        Font tamanoLetraOrigen = new Font("Arial", Font.PLAIN, 20);
        listaCiudadesDeOrigen.setFont(tamanoLetraOrigen);

        String [] ciudadesDestino = {"Seleccione el destino del viaje", "Quellón", "Puerto Montt", "Villarrica", "Concepción", "Rancagua"};
        listaCiudadesDeDestino= new JComboBox(ciudadesDestino);
        listaCiudadesDeDestino.setBounds(600,340,310,50);
        listaCiudadesDeDestino.setMaximumRowCount(4);
        Font tamanoLetraDestino = new Font("Arial", Font.PLAIN, 20);
        listaCiudadesDeDestino.setFont(tamanoLetraDestino);

        String [] fecha = {"Seleccione la fecha del viaje"};
        listaFechasViaje = new JComboBox(fecha);
        listaFechasViaje.setBounds(1050,340,300,50);
        listaFechasViaje.setMaximumRowCount(4);
        Font tamanoLetraFecha = new Font("Arial", Font.PLAIN, 20);
        listaFechasViaje.setFont(tamanoLetraFecha);

        buscarViajes = new JButton("Buscar viajes");
        buscarViajes.setBounds(600,600,280,70);
        buscarViajes.setFocusPainted(false);
        Font tamanoLetraBuscarViajes = new Font("Cooper black",Font.PLAIN,24);
        buscarViajes.setFont(tamanoLetraBuscarViajes);
        buscarViajes.setForeground(Color.blue);
        buscarViajes.setBackground(Color.white);

    }

    public JComboBox getListaCiudadesOrigen() {
        return listaCiudadesDeOrigen;
    }
    public JComboBox getListaCiudadesDeDestino(){
        return listaCiudadesDeDestino;
    }
    public JComboBox getListaFechasViaje(){
        return listaFechasViaje;
    }

    public JButton getBuscarViajes() {
        return buscarViajes;
    }
}
