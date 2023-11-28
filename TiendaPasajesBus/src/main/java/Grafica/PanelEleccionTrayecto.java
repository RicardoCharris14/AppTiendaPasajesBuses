package Grafica;

import Logica.EmpresaBuses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelEleccionTrayecto extends JPanel {

    private Image emeBusChocado;
    private Image emeBusLogo;
    private ListaOpcionesDesplegables opciones;

    public PanelEleccionTrayecto(EmpresaBuses empresaBuses) {

        PanelFotoEncabezado fotoEncabezado = new PanelFotoEncabezado();
        fotoEncabezado.setBounds(120, 30, 1200, 180);

        opciones = new ListaOpcionesDesplegables(empresaBuses);

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
    public void accionBtnBuscarTrayecto(ActionListener e){
        opciones.getBtnBuscarViajes().addActionListener(e);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(emeBusChocado,60,370,500,300,this);
        g.drawImage(emeBusLogo,900,260,500,500,this);

    }
    public ListaOpcionesDesplegables getOpciones(){
        return opciones;
    }

}