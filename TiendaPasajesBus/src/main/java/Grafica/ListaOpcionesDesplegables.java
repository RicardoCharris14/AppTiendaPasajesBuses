package Grafica;

import Logica.EmpresaBuses;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ListaOpcionesDesplegables{
    private JComboBox listaCiudadesDeOrigen;
    private JComboBox listaCiudadesDeDestino;
    private JComboBox listaFechasViaje;
    private JButton buscarViajes;


    public ListaOpcionesDesplegables(EmpresaBuses empresaBuses) {
        ArrayList<String> ciudades = empresaBuses.getCiudadesAsociadas();
        int NroCiudades = ciudades.size();
        String [] ciudadesOrigen = new String[NroCiudades+1];
        String [] ciudadesDestino = new String[NroCiudades+1];

        ArrayList<LocalDate> fechasViajes = empresaBuses.getFechasViajes();
        int NroFechas = fechasViajes.size();
        String [] fechas = new String[NroFechas+1];

        ciudadesOrigen[0] = "Seleccione el destino del viaje";
        for(int i=1;i<=NroCiudades;i++){
            ciudadesOrigen[i]=ciudades.get(i-1);
        }
        listaCiudadesDeOrigen = new JComboBox(ciudadesOrigen);
        listaCiudadesDeOrigen.setBounds(150,340,300,50);
        listaCiudadesDeOrigen.setMaximumRowCount(4);
        Font tamanoLetraOrigen = new Font("Arial", Font.PLAIN, 20);
        listaCiudadesDeOrigen.setFont(tamanoLetraOrigen);

        ciudadesDestino[0] = "Seleccione el destino del viaje";
        for(int i=1;i<=NroCiudades;i++){
            ciudadesDestino[i]=ciudades.get(i-1);
        }
        listaCiudadesDeDestino= new JComboBox(ciudadesDestino);
        listaCiudadesDeDestino.setBounds(600,340,310,50);
        listaCiudadesDeDestino.setMaximumRowCount(4);
        Font tamanoLetraDestino = new Font("Arial", Font.PLAIN, 20);
        listaCiudadesDeDestino.setFont(tamanoLetraDestino);


        fechas[0] = "Seleccione la fecha del viaje";
        for(int i=1;i<=NroFechas;i++){
            fechas[i] = fechasViajes.get(i-1).toString();
        }
        listaFechasViaje = new JComboBox(fechas);
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