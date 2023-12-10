package Grafica;

import javax.swing.*;
import java.awt.*;

public class PanelDatosComprador extends JPanel {
    private JTextField nombreUsuario;
    private JTextField rutUsuario;
    public PanelDatosComprador(){
        nombreUsuario = new JTextField();
        nombreUsuario.setBackground(Color.WHITE);
        nombreUsuario.setFont(new Font("Arial",Font.ITALIC,50));
        nombreUsuario.setBounds(450,160,800,100);

        rutUsuario = new JTextField();
        nombreUsuario.setBackground(Color.WHITE);
        rutUsuario.setFont(new Font("Arial",Font.ITALIC,50));
        rutUsuario.setBounds(450,310,800,100);

        this.add(nombreUsuario);
        this.add(rutUsuario);

        this.setBackground(Color.BLACK);
        this.setLayout(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.orange);
        g.setFont(new Font("Arial",Font.BOLD,70));
        g.drawString("Ingrese los datos del comprador",170,100);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial",Font.BOLD,20));
        g.drawString("Ingrese el nombre completo",160,200);
        g.drawString("del comprador: ",210,240);
        g.drawString("Ingrese el Rut",210,350);
        g.drawString("del comprador:",210,390);
    }
}
