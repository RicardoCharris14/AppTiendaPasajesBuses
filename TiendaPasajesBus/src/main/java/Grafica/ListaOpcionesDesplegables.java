package Grafica;

import Logica.EmpresaBuses;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ListaOpcionesDesplegables{
    private JComboBox ciudadesOrigen;
    private JComboBox ciudadesDestino;
    private JComboBox fechasViaje;
    private JButton BtnBuscarViajes;


    public ListaOpcionesDesplegables(EmpresaBuses empresaBuses) {
        ArrayList<String> ciudades = empresaBuses.getCiudadesAsociadas();
        int NroCiudades = ciudades.size();
        String [] ciudadesOrigen = new String[NroCiudades+1];
        String [] ciudadesDestino = new String[NroCiudades+1];

        ArrayList<LocalDate> fechasViajes = empresaBuses.getFechasViajes();
        int NroFechas = fechasViajes.size();
        String [] fechas = new String[NroFechas+1];

        ciudadesOrigen[0] = "Seleccione origen del viaje";
        for(int i=1;i<=NroCiudades;i++){
            ciudadesOrigen[i]=ciudades.get(i-1);
        }
        this.ciudadesOrigen = new JComboBox(ciudadesOrigen);
        this.ciudadesOrigen.setBounds(150,240,300,50);
        this.ciudadesOrigen.setMaximumRowCount(4);
        Font tamanoLetraOrigen = new Font("Arial", Font.PLAIN, 20);
        this.ciudadesOrigen.setFont(tamanoLetraOrigen);

        ciudadesDestino[0] = "Seleccione destino del viaje";
        for(int i=1;i<=NroCiudades;i++){
            ciudadesDestino[i]=ciudades.get(i-1);
        }
        this.ciudadesDestino = new JComboBox(ciudadesDestino);
        this.ciudadesDestino.setBounds(600,240,310,50);
        this.ciudadesDestino.setMaximumRowCount(4);
        Font tamanoLetraDestino = new Font("Arial", Font.PLAIN, 20);
        this.ciudadesDestino.setFont(tamanoLetraDestino);


        fechas[0] = "Seleccione la fecha del viaje";
        for(int i=1;i<=NroFechas;i++){
            fechas[i] = fechasViajes.get(i-1).toString();
        }
        fechasViaje = new JComboBox(fechas);
        fechasViaje.setBounds(1050,240,300,50);
        fechasViaje.setMaximumRowCount(4);
        Font tamanoLetraFecha = new Font("Arial", Font.PLAIN, 20);
        fechasViaje.setFont(tamanoLetraFecha);


        BtnBuscarViajes = new JButton("Buscar viajes");
        BtnBuscarViajes.setBounds(600,450,280,70);
        BtnBuscarViajes.setFocusPainted(false);
        Font tamanoLetraBuscarViajes = new Font("Cooper black",Font.PLAIN,24);
        BtnBuscarViajes.setFont(tamanoLetraBuscarViajes);
        BtnBuscarViajes.setBorder(new BevelBorder(BevelBorder.RAISED));
        BtnBuscarViajes.setForeground(Color.blue);
        BtnBuscarViajes.setBackground(Color.white);
    }

    public JComboBox getCiudadesOrigen() {
        return ciudadesOrigen;
    }
    public JComboBox getCiudadesDestino(){
        return ciudadesDestino;
    }
    public JComboBox getFechasViaje(){
        return fechasViaje;
    }

    public JButton getBtnBuscarViajes() {
        return BtnBuscarViajes;
    }
}