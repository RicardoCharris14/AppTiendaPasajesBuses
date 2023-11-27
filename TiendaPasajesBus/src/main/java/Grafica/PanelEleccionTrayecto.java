package Grafica;

import Logica.EmpresaBuses;

import javax.swing.*;
import java.awt.*;

public class PanelEleccionTrayecto extends JPanel {

    private Image emeBusChocado;
    private Image emeBusLogo;

    public PanelEleccionTrayecto(EmpresaBuses empresaBuses) {

        PanelFotoEncabezado fotoEncabezado = new PanelFotoEncabezado();
        fotoEncabezado.setBounds(150, 30, 1200, 250);

        ListaOpcionesDesplegables listaOrigenDestinoFecha = new ListaOpcionesDesplegables(empresaBuses);

        emeBusChocado = new ImageIcon("src/main/java/Grafica/Imagenes/busemeChocado.png").getImage();
        emeBusLogo = new ImageIcon("src/main/java/Grafica/Imagenes/emebusLogo.png").getImage();

        this.add(fotoEncabezado);
        this.add(listaOrigenDestinoFecha.getListaCiudadesOrigen());
        this.add(listaOrigenDestinoFecha.getListaCiudadesDeDestino());
        this.add(listaOrigenDestinoFecha.getListaFechasViaje());
        this.add(listaOrigenDestinoFecha.getBuscarViajes());


        this.setBackground(Color.yellow);
        this.setLayout(null);
        this.setBounds(205, 85, 1500, 850);

        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(emeBusChocado,75,500,500,300,this);
        g.drawImage(emeBusLogo,900,370,500,500,this);

    }

}

