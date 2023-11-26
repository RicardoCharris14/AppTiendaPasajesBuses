package Grafica;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PanelFotoEncabezado extends JPanel {

    private Image fotoEncabezado; //foto del logo de bus

    public PanelFotoEncabezado(){

        fotoEncabezado = new ImageIcon("src/main/java/Grafica/Imagenes/busChocado.png").getImage();
        this.setLayout(null);
        this.setBackground(Color.red);
        LineBorder borde = new LineBorder(Color.BLACK, 2, true);
        this.setBorder(borde);

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(fotoEncabezado,0,0,this.getWidth(),this.getHeight(),this);
    }

}
