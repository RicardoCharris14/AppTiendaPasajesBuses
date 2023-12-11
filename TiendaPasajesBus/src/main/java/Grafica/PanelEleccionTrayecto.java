package Grafica;

import Logica.EmpresaBuses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * JPanel que muestra los origenes, destinos y fechas de viaje disponibles, ademas permite al usuario seleccionar un
 * itinerario de viaje
 * @author Vicente Ramirez
 * @author Ricardo Charris
 */
public class PanelEleccionTrayecto extends JPanel {

    private Image emeBusChocado;
    private Image emeBusLogo;
    private ListaOpcionesDesplegables opciones;

    public PanelEleccionTrayecto() {
        EmpresaBuses empresaBuses = EmpresaBuses.getEmpresaBuses(0);

        PanelFotoEncabezado fotoEncabezado = new PanelFotoEncabezado();
        fotoEncabezado.setBounds(120, 30, 1200, 180);

        opciones = new ListaOpcionesDesplegables();

        emeBusChocado = new ImageIcon("src/main/java/Grafica/Imagenes/busemeChocado.png").getImage();
        emeBusLogo = new ImageIcon("src/main/java/Grafica/Imagenes/emebusLogo.png").getImage();

        this.add(fotoEncabezado);
        this.add(opciones.getCiudadesOrigen());
        this.add(opciones.getCiudadesDestino());
        this.add(opciones.getFechasViaje());
        this.add(opciones.getBtnBuscarViajes());

        this.setBackground(Color.yellow);
        this.setLayout(null);
    }

    /**
     * anade un ActionListener al boton de buscar viajes
     * @param e ActionListener que permite filtrar los buses que se le mostraran al usuario segun el itinerario escogido
     */
    public void accionBtnBuscarTrayecto(ActionListener e){
        opciones.getBtnBuscarViajes().addActionListener(e);
    }

    /**
     * dibuja las fotos de decoracion
     * @param g  the <code>Graphics</code> context in which to paint
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(emeBusChocado,60,370,500,300,this);
        g.drawImage(emeBusLogo,870,260,500,500,this);

    }
    public ListaOpcionesDesplegables getOpciones(){
        return opciones;
    }

}